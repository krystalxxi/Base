package com.demo.base.netty.example02;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Krystal on 2019/5/7.
 * 利用LineBasedFrameDecoder处理粘包
 */
public class TimeServerHandler extends ChannelHandlerAdapter {
    private int counter;
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
        String body = (String)msg;
        System.out.println("The time server receive order :" + body +"; the counter is :" + ++counter);

        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new java.util.Date(
                System.currentTimeMillis()).toString():"BAD ORDER";
                currentTime = currentTime + System.getProperty("line.separator");
                ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
                ctx.writeAndFlush(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception{
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        ctx.close();
    }
}