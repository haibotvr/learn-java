package com.simon.learn.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

/**
 * 一、通道(Channel):用于源节点与目标节点的连接。在Java nio中负责缓冲区中数据的传输。Channel本身不存储数据，因此需要配合缓冲区进行传输数据。
 *
 * 二、通道的主要实现类
 * java.nio.channels.Channel 接口
 *
 *      FileChannel
 *      SocketChannel
 *      ServerSocketChannel
 *      DatagramChannel
 *
 * 三、获取通道
 * 1. Java针对支持通道的类提供了getChannel()方法
 *  本地IO
 *   FileInputStream/FileOutputStream
 *   RandomAccessFile
 *  网络IO
 *   Socket
 *   ServerSocket
 *   DatagramSocket
 * 2. 在JDK 1.7 中的NIO.2针对各个通道提供了静态方法open()
 * 3. 在JDK 1.7 中的NIO.2的Files工具类的newByteChannel()方法
 *
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 *
 * 五、分散（Scatter）与聚集（Gather）
 * 分散读取（Scattering Reads）:将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gathering Writes）:将多个缓冲区中的数据聚集到通道中
 *
 * 六、字符集：Charset
 * 编码：字符串 -> 字节数组
 * 解码：字节数组 -> 字符串
 */
public class TestChannel {

    //字符集
    @Test
    public void test6(){

        Charset cs1 = Charset.forName("UTF-8");
        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();
        //获取解码器
//        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("我是程序员");
        charBuffer.flip();

        try {
            //编码
            ByteBuffer byteBuffer = ce.encode(charBuffer);
            for (int i = 0; i < 15; i++){
                System.out.println(byteBuffer.get());
            }
            //解码
            byteBuffer.flip();
            CharBuffer charBuffer2 = cs1.decode(byteBuffer);
            System.out.println(charBuffer2.toString());

            System.out.println("========================");

            byteBuffer.flip();
            Charset cs2 = Charset.forName("GBK");
            //当出现"半个汉字时"用CharsetDecoder会报错，这里直接用Charset.decode()方法
//            CharsetDecoder cd2 = cs2.newDecoder();
            CharBuffer charBuffer3 = cs2.decode(byteBuffer);
            System.out.println(charBuffer3.toString());

        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }


    }

    //字符集
    @Test
    public void test5(){

        Map<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> set = map.entrySet();
        for (Map.Entry<String, Charset> entry: set){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }

    //分散读取与聚集写入
    @Test
    public void test4(){

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;

        try {
            raf1 = new RandomAccessFile("1.txt", "rw");
            raf2 = new RandomAccessFile("2.txt", "rw");
            //1.获取通道
            FileChannel channel1 = raf1.getChannel();
            FileChannel channel2 = raf2.getChannel();
            //2.分配指定大小的缓冲区
            ByteBuffer buffer1 = ByteBuffer.allocate(100);
            ByteBuffer buffer2 = ByteBuffer.allocate(1024);
            //3.分散读取
            ByteBuffer[] buffers = {buffer1, buffer2};
            while (channel1.read(buffers) != -1){
                for (ByteBuffer buffer: buffers){
                    buffer.flip();
                }
                System.out.println(new java.lang.String(buffers[0].array(), 0, buffers[0].limit()));
                System.out.println("===================================================");
                System.out.println(new java.lang.String(buffers[1].array(), 0, buffers[1].limit()));
                //4.聚集写入
                channel2.write(buffers);
                for (ByteBuffer buffer: buffers){
                    buffer.clear();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //通道之间的数据传输
    @Test
    public void test3(){

        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            inChannel = FileChannel.open(Paths.get("4.jpg"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("5.jpg"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);

//            inChannel.transferTo(0, inChannel.size(), outChannel);
            outChannel.transferFrom(inChannel, 0, inChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //利用直接缓冲区完成文件的复制（内存映射文件）
    @Test
    public void test2(){

        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            inChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);

            //内存映射文件
            MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            //直接对缓冲区进行数据的读写操作
            byte[] dst = new byte[inMappedBuffer.limit()];
            inMappedBuffer.get(dst);
            outMappedBuffer.put(dst);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //利用通道完成文件的复制（非直接缓冲区）
    @Test
    public void test1(){

        //定义文件流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //获取通道
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            fis = new FileInputStream("1.jpg");
            fos = new FileOutputStream("2.jpg");

            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            //分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //将通道中的数据存入缓冲区中
            while (inChannel.read(buffer) != -1){
                //切换读取数据模式
                buffer.flip();
                //将缓冲区中的数据写入通道中
                outChannel.write(buffer);
                //清空缓冲区
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
