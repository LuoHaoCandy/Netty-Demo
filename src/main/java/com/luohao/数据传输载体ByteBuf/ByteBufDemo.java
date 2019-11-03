package com.luohao.数据传输载体ByteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author luohao
 * @comment 关于ByteBuf的API实践
 * @date 2019/11/3
 */
public class ByteBufDemo {

    public static void main(String[] args) {

        //获取buffer对象
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(9, 100);

        //获取容量
        System.out.println(buffer.capacity());
        //获取最大容量
        System.out.println(buffer.maxCapacity());
        //readableBytes() 可读字节 与 isReadable() 是否可读
        System.out.println(buffer.isReadable());
        System.out.println(buffer.readableBytes());

        //writableBytes() 可写字节 与 isWritable() 是否可写
        System.out.println(buffer.isWritable());
        System.out.println(buffer.writableBytes());

        //markReaderIndex() 当前的读指针保存起来  与 resetReaderIndex() 当前的读指针恢复到之前保存的值
        System.out.println(buffer.markReaderIndex());
        System.out.println(buffer.resetReaderIndex());

        //writeBytes() 写字节 readByte()读字节
        System.out.println(buffer.writeBytes(new byte[]{1,2}));
//        System.out.println(buffer.readByte());

        //release() 引用-1 与 retain() 引用+1
        System.out.println(buffer.retain());
        System.out.println(buffer.readByte());

        System.out.println(buffer.release());

        //slice() 截取片段
        //duplicate() 全部
        //引用计数共享,读写指针不共享
        System.out.println(buffer.slice(1,2));
        System.out.println(buffer.duplicate());





    }
}
