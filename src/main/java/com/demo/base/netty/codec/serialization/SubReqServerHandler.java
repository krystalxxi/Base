package com.demo.base.io.netty.codec.serialization;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Krystal on 2019/5/7.
 * Netty - Java序列化
 * ObjectDecoder ObjectEncoder
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
        SubscribeReq req = (SubscribeReq)msg;
        if ("Lilinfeng".equalsIgnoreCase(req.getUserName())){
            System.out.println("Service accept client subscribe req: [" + req.toString()+"]");
            ctx.writeAndFlush(resp(req.getSubReqId()));
        }
    }

    private SubscribeResp resp(int subReqID){
        SubscribeResp resp  = new SubscribeResp();
        resp.setSubReqID(subReqID);
        resp.setRespCode(0);
        resp.setDesc("Netty book order succeed, 3 days later");
        return  resp;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        ctx.close();
    }
}
