package com.luohao.客户端和服务端的协议编码;

import com.luohao.客户端和服务端的协议编码.serializer.Serializer;

/**
 * @author luohao
 * @date 2019/11/3
 */
public class Packet implements java.io.Serializable {

    private Byte version;

    private String className;

    private String param;

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
