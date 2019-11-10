package com.luohao.客户端和服务端的协议编码.serializer;


import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class HessianSerializer implements Serializer {

    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output ho = new Hessian2Output(os);
        try {
            ho.writeObject(obj);
            ho.flush();
            byte[] result = os.toByteArray();
            return result;
        } catch (IOException e) {
            return null;
        } finally {
            try {
                ho.close();
            } catch (IOException e) {

            }
            try {
                os.close();
            } catch (IOException e) {

            }
        }

    }

    @Override
    public <T> Object deserialize(byte[] bytes, Class<T> clazz) {
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        Hessian2Input hi = new Hessian2Input(is);
        try {
            Object result = hi.readObject();
            return result;
        } catch (IOException e) {
            return null;
        } finally {
            try {
                hi.close();
            } catch (Exception e) {
            }
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }

}
