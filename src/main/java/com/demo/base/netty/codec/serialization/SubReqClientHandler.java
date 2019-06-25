package com.demo.base.netty.codec.serialization;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Krystal on 2019/5/7.
 * Netty - Java序列化
 * ObjectDecoder ObjectEncoder
 */
public class SubReqClientHandler extends ChannelHandlerAdapter {
    public SubReqClientHandler(){

    }
    @Override
    public void channelActive(ChannelHandlerContext ctx){
        for(int i = 0;i < 10; i++){
            ctx.write(subReq(i));
        }
        ctx.flush();
    }
    private SubscribeReq subReq(int i){
        SubscribeReq req = new SubscribeReq();
        req.setAddress("nanjing");
        req.setPhoneNumber("124");
        req.setSubReqId(i);
        req.setUserName("Lilinfeng");
        req.setProductName("Netty权威指南");
        return req;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
        System.out.println("Receive server response: [" + msg +"]");
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
