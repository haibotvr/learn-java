package com.simon.learn.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 一、使用NIO完成网络通信的三个核心
 * 1. 通道 Channel: 负责连接
 *    java.nio.channels.Channel接口
 *      SelectableChannel
 *          SocketChannel
 *          ServerSocketChannel
 *          DatagramChannel
 *
 *          Pipe.SinkChannel
 *          Pipe.SourceChannel
 *
 *
 * 2. 缓冲区 Buffer: 负责数据的存取
 *
 * 3. 选择器 Selector: 是SelectableChannel的多路复用器，用户监控SelectableChannel的IO状况
 */
public class TestBlockingNIO {

    //客户端
    @Test
    public void client(){

        SocketChannel socketChannel = null;
        FileChannel fileChannel = null;

        try {
            //1.获取通道
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
            fileChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
            //2.分配指定大小缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //3.读取本地文件并发送到服务端
            while (fileChannel.read(buffer) != -1){
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭通道
            if(fileChannel != null){
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socketChannel != null){
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //服务端
    @Test
    public void server(){

        ServerSocketChannel serverSocketChannel = null;
        FileChannel fileChannel = null;
        SocketChannel socketChannel = null;

        try {
            //1.获取通道
            serverSocketChannel = ServerSocketChannel.open();

            fileChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            //2.服务端绑定端口
            serverSocketChannel.bind(new InetSocketAddress(9999));
            //3.获取客户端通道
            socketChannel = serverSocketChannel.accept();
            //4.分配指定大小缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //5.读取本地文件并发送到服务端
            while (socketChannel.read(buffer) != -1){
                buffer.flip();
                fileChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭通道
            if(fileChannel != null){
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socketChannel != null){
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocketChannel != null){
                try {
                    serverSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
