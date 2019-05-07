package com.demo.base.io.netty.example01;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

/**
 * Created by Krystal on 2019/5/7.
 */
public class TimeClientHandler extends ChannelHandlerAdapter {
    private static final Logger logger = Logger.getLogger(TimeClientHandler.class.getName());
    private final ByteBuf firstMessage;
    private int counter;
    private byte[] req;

    public TimeClientHandler(){
        req = "QUERY TIME ORDER".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        ByteBuf message = null;
        // 发生粘包，客户端应收到100条服务器的回复，但实际只收到2条，因为发生了粘包，服务端实际只收到2条
        for (int i = 0;i < 100;i++){
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");
        System.out.println("Now is :" + body+"; the counter is:" + ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        logger.warning("Unexcepted exception from downstream:" +cause.getMessage());
        ctx.close();
    }

}
