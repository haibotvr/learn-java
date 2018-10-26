package com.simon.learn.nio;

import com.sun.security.ntlm.Server;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

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
public class TestNoneBlockingNIO {

    public static void main(String[] args) {
        TestNoneBlockingNIO blockingNIO = new TestNoneBlockingNIO();
        blockingNIO.client();
    }

    //客户端，junit运行控制台不能输入
    @Test
    public void client(){
        //1.获取通道
        SocketChannel socketChannel = null;
        Scanner scanner = null;
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
            //2.切换成非阻塞模式
            socketChannel.configureBlocking(false);
            //3.分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //4.发送数据给服务端
            scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                String str = scanner.next();
                buffer.put((new Date().toString() + "\n" + str).getBytes());
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭通道
            if(socketChannel != null){
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(scanner != null){
                try {
                    scanner.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //服务端
    @Test
    public void server(){

        //1.获取通道
        ServerSocketChannel serverSocketChannel = null;

        try {

            serverSocketChannel = ServerSocketChannel.open();
            //2.切换成非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //3.绑定连接
            serverSocketChannel.bind(new InetSocketAddress(9999));
            //4.获取选择器
            Selector selector = Selector.open();
            //5.将通道注册到选择器上，并且指定"监听接收事件"
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //6.轮巡式的获取选择器上已经"准备就绪"的事件
            while (selector.select() > 0){
                //7.获取当前选择器中所有注册的"选择键（已就绪的监听事件）"
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    //8.获取"准备就绪"的事件
                    SelectionKey sk = iterator.next();
                    //9.判断具体是什么事件准备就绪
                    if(sk.isAcceptable()){
                        //10.若接收就绪，获取客户端连接
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        //11.切换非阻塞模式
                        socketChannel.configureBlocking(false);
                        //12.将该通道注册到选择器上，并指定"监听读事件"
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }else if(sk.isReadable()){
                        //13.获取当前选择器上读就绪的状态的通道
                        SocketChannel socketChannel = (SocketChannel) sk.channel();
                        //14.读取数据
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int len = 0;
                        while ((len = socketChannel.read(buffer)) > 0){
                            buffer.flip();
                            System.out.println(new String(buffer.array(), 0 , buffer.limit()));
                            buffer.clear();
                        }

                    }

                    //15.取消选择键
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //16.关闭通道
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
