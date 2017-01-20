package com.test.netty;

/**
 * Created by jiaxl on    /   /
 */

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

public class EchoClient {

    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group);
            b.channel(NioSocketChannel.class);
            b.remoteAddress(new InetSocketAddress(host, port));
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new EchoClientHandler());
                }
            });
            ChannelFuture f = b.connect().sync();
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoClient("localhost", 65535).start();
    }
 }

 class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf>{

     @Override
     public void channelActive(ChannelHandlerContext ctx) throws Exception {
         System.out.println("channelActive");
         ctx.write(Unpooled.copiedBuffer("Netty  rocks!", CharsetUtil.UTF_8));
     }

     @Override
     protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
         System.out.println("Client  received:  "+ByteBufUtil.hexDump(msg.readBytes(msg.readableBytes())));
     }
 }