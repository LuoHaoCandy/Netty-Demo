package com.luohao.pipeline与channelHandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author luohao
 * @date 2019/11/11
 */
public class OneInBoundHandlerApater extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("one"+ctx.read().channel());
        super.channelRead(ctx, msg);
    }
}
