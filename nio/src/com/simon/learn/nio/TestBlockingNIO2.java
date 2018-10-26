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
public class TestBlockingNIO2 {

    //客户端
    @Test
    public void client(){

        SocketChannel socketChannel = null;
        FileChannel fileChannel = null;

        try {
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
            fileChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(buffer) != -1){
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
            }
            socketChannel.shutdownOutput();
            //读取服务端消息
            int len = 0;
            while ((len = socketChannel.read(buffer)) != -1){
                buffer.flip();
                System.out.println(new String(buffer.array(), 0, len));
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
            serverSocketChannel = ServerSocketChannel.open();
            fileChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            serverSocketChannel.bind(new InetSocketAddress(9999));
            socketChannel = serverSocketChannel.accept();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (socketChannel.read(buffer) != -1){
                buffer.flip();
                fileChannel.write(buffer);
                buffer.clear();
            }
            //反馈信息到客户端
            buffer.put("您到礼物已经收到了".getBytes());
            buffer.flip();
            socketChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
