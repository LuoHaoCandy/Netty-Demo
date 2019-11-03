# Netty-Demo

#### 一.服务端的启动流程

   * 创建俩个线程组 `NioEventLoopGroup` ,一个boss 用来接收连接.一个用来处理连接.
   * 创建一个引导类,然后通过 `group()` 方法和线程组进行绑定.
   * 通过  `channel()`方法来绑定处理模式,可以选择NIO,OIO,EPOLL等.
   * 调用`channelHandler()` 来做一个逻辑处理的初始化.
   * 对端口进行绑定.

#### 二.客户端的启动流程

   * 创建一个线程组,用来处理连接.
   * 创建一个引导类,这里使用的是BootStrap.
   * 基本和服务端流程一直,略

#### 三.客户端和服务端通信

   * 通过在channelHandler的调用链里设置一个自定义的Handle来进行数据的读取和写入
   * 关于ChannelHandler里的方法其实就是整个调用过程中ChannelHandler的生命周期,后续补充

