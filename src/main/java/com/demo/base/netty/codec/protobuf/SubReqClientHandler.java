package com.demo.base.netty.codec.protobuf;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Krystal on 2019/5/7.
 */
public class SubReqClientHandler extends ChannelHandlerAdapter {
    public SubReqClientHandler(){

    }
    @Override
    public void channelActive(ChannelHandlerContext ctx){
        for (int i = 0;i < 10;i++){
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubscribeReqProto.SubscribeReq subReq(int i){

        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(i);
        builder.setUserName("Lilinfeng");
        builder.setProductName("Netty Book For Protobuf");
        return  builder.build();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
        System.out.println("Receive Server response: ["+msg+"]");

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
