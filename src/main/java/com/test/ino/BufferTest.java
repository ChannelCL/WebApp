package com.test.ino;

import java.nio.ByteBuffer;

/**
 * Created by jiaxl on 2017/1/16.
 */

/**
 * 一、缓冲区（Buffer）：在 Java NIO 中负责数据的存取。缓冲区就是数组。用于存储不同数据类型的数据
 *
 * 根据数据类型不同（boolean 除外），提供了相应类型的缓冲区：
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过 allocate() 获取缓冲区
 *
 * 二、缓冲区存取数据的两个核心方法：
 * put() : 存入数据到缓冲区中
 * get() : 获取缓冲区中的数据
 *
 * 三、缓冲区中的四个核心属性：
 * capacity : 容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 * limit : 界限，表示缓冲区中可以操作数据的大小。（limit 后数据不能进行读写）
 * position : 位置，表示缓冲区中正在操作数据的位置。
 *
 * mark : 标记，表示记录当前 position 的位置。可以通过 reset() 恢复到 mark 的位置
 *
 * 0 <= mark <= position <= limit <= capacity
 *
 * 四、直接缓冲区与非直接缓冲区：
 * 非直接缓冲区：通过 allocate() 方法分配缓冲区，将缓冲区建立在 JVM 的内存中
 * 直接缓冲区：通过 allocateDirect() 方法分配直接缓冲区，将缓冲区建立在物理内存中。
 * 可以提高效率，但是文件大于内存时，可能会出问题
 */
public class BufferTest {

    public static void main(String[] args) {
        String str="jiaxuelei";
        ByteBuffer buffer =ByteBuffer.allocate(1024);
        printIndexs(buffer);
        //写数据
        buffer.put(str.getBytes());
        printIndexs(buffer);
        //准备读操作
        buffer.flip();
        byte[]data=new byte[buffer.limit()];
        //读数据
        buffer.get(data,0,buffer.limit());
        System.out.println(new String(data));
        printIndexs(buffer);
        //准备重读操作
        buffer.rewind();
        printIndexs(buffer);
        data=new byte[buffer.limit()];
        System.out.println(buffer.remaining());
        buffer.get(data,0,9);
        System.out.println(new String(data));
        printIndexs(buffer);

    }

    private static void printIndexs(ByteBuffer buffer) {
        System.out.println("---------------------");
        System.out.println("BufferPosition:"+buffer.position());
        System.out.println("BufferLimit:"+buffer.limit());
        System.out.println("BufferCapacity:"+buffer.capacity());
        System.out.println("---------------------\n");
    }
}
