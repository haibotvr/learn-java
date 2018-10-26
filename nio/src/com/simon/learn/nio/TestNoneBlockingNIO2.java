package com.simon.learn.nio;

import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
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
public class TestNoneBlockingNIO2 {

    @Test
    public void send(){
        DatagramChannel datagramChannel = null;

        try {
            datagramChannel = DatagramChannel.open();
            datagramChannel.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("我要发送数据".getBytes());
            buffer.flip();
            datagramChannel.send(buffer, new InetSocketAddress("127.0.0.1", 9999));
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(datagramChannel != null){
                try {
                    datagramChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void receive(){
        DatagramChannel datagramChannel = null;

        try {
            datagramChannel = DatagramChannel.open();
            datagramChannel.configureBlocking(false);
            datagramChannel.bind(new InetSocketAddress(9999));
            Selector selector = Selector.open();
            datagramChannel.register(selector, SelectionKey.OP_READ);
            while (selector.select() > 0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey sk = iterator.next();
                    if(sk.isReadable()){
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        datagramChannel.receive(buffer);
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, buffer.limit()));
                        buffer.clear();
                    }
                }
                iterator.remove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(datagramChannel != null){
                try {
                    datagramChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
