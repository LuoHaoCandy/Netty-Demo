package com.luohao.pipeline与channelHandler;

import com.luohao.客户端和服务端的协议编码.Decodec;
import com.luohao.客户端和服务端的协议编码.Encodec;
import com.luohao.客户端和服务端的协议编码.Packet;
import com.luohao.客户端和服务端通信.ClientChannelHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.ExecutionException;

/**
 * @author luohao
 * @date 2019/11/3
 */
public class NettyClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                // 1.指定线程模型
                .group(workerGroup)
                // 2.指定 IO 类型为 NIO
                .channel(NioSocketChannel.class)
                // 3.IO 处理逻辑
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) {
                        ch.pipeline().addLast(new Encodec());
                        ch.pipeline().addLast(new Decodec());
                        ch.pipeline().addLast(new ClientChannelHandler());


                    }
                });
        // 4.建立连接
        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8000).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("连接已经建立");
                }
            }
        });

        channelFuture.channel().writeAndFlush("123");


    }

}
