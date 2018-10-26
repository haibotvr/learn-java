package com.simon.learn.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

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
public class TestPipe {

    @Test
    public void test1(){

        Pipe.SinkChannel sinkChannel = null;
        Pipe.SourceChannel sourceChannel = null;

        try {
            //1.获取管道
            Pipe pipe = Pipe.open();
            //2.将缓冲区中数据写入管道
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            sinkChannel = pipe.sink();
            buffer.put("通过管道发送数据".getBytes());
            buffer.flip();
            sinkChannel.write(buffer);
            //3.读取缓冲区中的数据
            sourceChannel = pipe.source();
            buffer.flip();
            sourceChannel.read(buffer);
            System.out.println(new String(buffer.array(), 0, buffer.limit()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(sourceChannel != null){
                try {
                    sourceChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(sinkChannel != null){
                try {
                    sinkChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
