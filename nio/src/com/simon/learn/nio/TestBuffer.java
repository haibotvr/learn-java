package com.simon.learn.nio;


import java.nio.ByteBuffer;

/**
 * 一、缓冲区（Buffer）: 在java nio中负责数据的存取。缓冲区就是数组。用户存取不同类型的数据
 *
 * 根据不同类型的数据（boolean除外），提供了相应类型的缓冲区：
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过allocate()获取缓冲区
 *
 * 二、缓冲区中存取数据的两个核心方法
 * put(): 存入数据到缓冲区中
 * get(): 获取缓冲区中的数据
 *
 * 三、缓冲区中的四个核心属性
 * capacity: 容量，表示缓冲区中存储数据的最大容量，一旦生命不能修改
 * limit: 界限，表示缓冲区中可以操作数据的大小（limit后数据不能进行读写）
 * position: 位置，表示缓冲区中正在操作数据的位置
 * mark: 标记，记录当前缓冲区的位置，可以通过reset()恢复到mark的位置
 *
 * 0 <= mark <= position <= limit <= capacity
 *
 * 四、直接缓冲区和非直接缓冲区
 * 非直接缓冲区: 通过allocate()方法分配缓冲区，将缓冲区建立在JVM内存中
 * 直接缓冲区: 通过allocateDirect()方法非配的缓冲区，将缓冲区建立在物理内存中，可以提高效率
 *
 */
public class TestBuffer {

    //主方法
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    public static void test3(){
        //创建直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        System.out.println(buffer.isDirect());
    }


    public static void test2(){

        String str = "hello";
        //分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());
        buffer.flip();
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst, 0, 2);
        System.out.println(new String(dst, 0, 2));
        System.out.println(buffer.position());
        //mark()标记位置
        buffer.mark();
        buffer.get(dst, 2, 2);
        System.out.println(new String(dst, 2, 2));
        System.out.println(buffer.position());
        //reset()恢复到mark的位置
        buffer.reset();
        System.out.println(buffer.position());
        //判断是否还有可读数据
        while (buffer.hasRemaining()){
            buffer.get(dst, buffer.position(), 1);
            System.out.println(new String(dst, buffer.position() - 1, 1));
        }

    }

    public static void test1(){

        String str = "abc";
        //1、分配一个指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("=================allocate()===================");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        //2、利用put()存数据到缓冲区
        buffer.put(str.getBytes());
        System.out.println("=================put()===================");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        //3、切换到读取数据的模式
        buffer.flip();
        System.out.println("=================flip()===================");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        //4、利用get()读取缓冲区的数据
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst, 0, dst.length));

        System.out.println("=================get()===================");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        //5、rewind()可重复读取
        buffer.rewind();
        System.out.println("=================rewind()===================");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        //6、clear()清空缓冲区，但是缓冲区的数据依然存在，但是处于"被遗忘"状态
        buffer.clear();
        System.out.println("=================clear()===================");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println((char) buffer.get());

    }


}
