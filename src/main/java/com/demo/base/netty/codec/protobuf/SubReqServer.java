package com.demo.base.netty.codec.protobuf;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * Created by Krystal on 2019/5/7.
 */
public class SubReqServer {
    public void bind(int port) throws Exception{
        EventLoopGroup bossGroup  = new NioEventLoopGroup();
        EventLoopGroup workGroup  = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch){
                            /**
                             *  ProtobufDecoder仅仅负责解码，它不支持读半包，
                             *  因此，在ProtobufDecoder前面，一定要有能够处理半包的解码器，有三种方式可以选择：
                             *  1、使用Netty提供的ProtobufVarint32FrameDecoder，它可以处理半包消息；
                             *  2、继承Netty提供的通用半包解码器LengthFieldBasedFrameDecoder；
                             *  3、继承ByteToMessageDecoder类，自己处理半包消息。
                             */
                           ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                           ch.pipeline().addLast(new ProtobufDecoder(SubscribeReqProto.SubscribeReq.getDefaultInstance()));
                           ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                           ch.pipeline().addLast(new ProtobufEncoder());
                           ch.pipeline().addLast(new SubReqServerHandler());
                        }
                    });
            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) throws Exception{
        int port = 8080;
        new SubReqServer().bind(port);
    }
}
