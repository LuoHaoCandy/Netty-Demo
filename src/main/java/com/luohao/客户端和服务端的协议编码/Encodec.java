package com.luohao.客户端和服务端的协议编码;

import com.luohao.客户端和服务端的协议编码.serializer.HessianSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author luohao
 * @date 2019/11/10
 */
public class Encodec extends MessageToByteEncoder<Object> {


    @Override public void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {

        HessianSerializer hessianSerializer = new HessianSerializer();
        byte[] bytes = hessianSerializer.serialize(msg);
        out.writeInt(bytes.length);
        out.writeBytes(bytes);

    }
}
