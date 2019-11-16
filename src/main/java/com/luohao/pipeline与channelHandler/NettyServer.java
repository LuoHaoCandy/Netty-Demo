package com.luohao.pipeline与channelHandler;

import com.luohao.客户端和服务端的协议编码.Decodec;
import com.luohao.客户端和服务端通信.ServerChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author luohao
 * @date 2019/11/3
 */
public class NettyServer {
    public static void main(String[] args) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new OneInBoundHandlerApater());
                        ch.pipeline().addLast(new TwoInBoundHandlerApater());
                        ch.pipeline().addLast(new ThreeInBoundHandlerApater());


                    }
                });

        serverBootstrap.bind(8000);
    }
}
