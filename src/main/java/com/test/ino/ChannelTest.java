package com.test.ino;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jiaxl on 2017/1/17.
 */
public class ChannelTest {

    /**
     * 一、通道（Channel）：用于源节点与目标节点的连接。在 Java NIO 中负责缓冲区中数据的传输。Channel 本身不存储数据，因此需要配合缓冲区进行传输。
     * <p>
     * 二、通道的主要实现类
     * java.nio.channels.Channel 接口：
     * |--FileChannel
     * |--SocketChannel
     * |--ServerSocketChannel
     * |--DatagramChannel
     * <p>
     * 三、获取通道
     * 1. Java 针对支持通道的类提供了 getChannel() 方法
     * 本地 IO：
     * FileInputStream/FileOutputStream
     * RandomAccessFile
     * <p>
     * 网络IO：
     * Socket
     * ServerSocket
     * DatagramSocket
     * <p>
     * 2. 在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
     * 3. 在 JDK 1.7 中的 NIO.2 的 Files 工具类的 newByteChannel()
     * <p>
     * 四、通道之间的数据传输
     * transferFrom()
     * transferTo()
     * <p>
     * 五、分散(Scatter)与聚集(Gather)
     * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
     * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
     * <p>
     * 六、字符集：Charset
     * 编码：字符串 -> 字节数组
     * 解码：字节数组  -> 字符串
     */

    public static void main(String[] args) {

        test1();
    }

    /**
     * 简单利用通道、缓存区复制文件
     */
    private static void test1() {

        FileInputStream fis=null;
        FileOutputStream fos=null;
        FileChannel inChannel=null;
        FileChannel outChannel=null;

        try {
            fis=new FileInputStream("yzm.jpg");
            fos=new FileOutputStream("yzm_bk.jpg");
            inChannel=fis.getChannel();
            outChannel=fos.getChannel();

            //jvm内存里挖一块空间
            ByteBuffer buffer=ByteBuffer.allocate(1024);
            int len=-1;//为了看到每次读取长度，学习使用

            //将通道连接的文件数据读出来写入缓存buffer中
            while((len=inChannel.read(buffer))!=-1){
                System.out.println(len);
                //准备读操作 将limit置为position，position置为0 清空标记
                buffer.flip();
                //写入通道 但对于缓存buffer来说是读取操作
                outChannel.write(buffer);
                //
                buffer.clear();
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            releaseRes(fis,fos,inChannel,outChannel);
        }

    }

    private static void releaseRes(FileInputStream fis,FileOutputStream fos,FileChannel inChannel,FileChannel outChannel) {

        if(fis!=null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(fos!=null){
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(inChannel!=null){
            try {
                inChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(outChannel!=null){
            try {
                outChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
