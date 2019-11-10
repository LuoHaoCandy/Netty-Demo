package com.luohao.客户端和服务端的协议编码.serializer;


public interface Serializer {

	 <T> byte[] serialize(T obj);

	 <T> Object deserialize(byte[] bytes, Class<T> clazz);
	
}
