package com.luohao.客户端和服务端的协议编码;

import com.luohao.客户端和服务端的协议编码.serializer.HessianSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * decoder
 *
 * @author xuxueli 2015-10-29 19:02:36
 */
public class Decodec extends ByteToMessageDecoder {

    @Override
    public final void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        in.markReaderIndex();
        int dataLength = in.readInt();
        if (dataLength < 0) {
            ctx.close();
        }
        byte[] data = new byte[dataLength];
        in.readBytes(data);
        HessianSerializer hessianSerializer=new HessianSerializer();
        Object obj = hessianSerializer.deserialize(data, Packet.class);
        out.add(obj);
    }
}
