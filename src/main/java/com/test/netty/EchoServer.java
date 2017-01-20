package com.test.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by jiaxl on 2017/1/19.
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup loopGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();

        bootstrap.group(loopGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.localAddress(port);

        bootstrap.childHandler(new ChannelInitializer() {
            @Override
            protected void initChannel(Channel channel) throws Exception {
                System.out.println("新来客户端..."+channel);
                channel.pipeline().addLast(new EchoServerHandler());
            }
        });
        ChannelFuture f =bootstrap.bind().sync();
        System.out.println(EchoServer.class.getName()+"started and listen on "+f.channel().localAddress());
        f.channel().closeFuture().sync();
        loopGroup.shutdownGracefully().sync();
    }

    public static void main(String[] args) throws InterruptedException {

        new EchoServer(65535).start();
    }
}
class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf=(ByteBuf)msg;
        byte[]data=new byte[buf.capacity()];
        System.out.println(buf.getBytes(0,data));
        System.out.println("Server Receive:"+new String(data));
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("发生异常");
        cause.printStackTrace();
        ctx.close();
    }
}
