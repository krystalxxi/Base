package com.demo.base.disruptor;


import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * Created by Krystal on 2019/6/25.
 * 事件消费者
 * 也就是一个事件处理器
 */
public class LongEventHandler implements EventHandler<LongEvent>,WorkHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent arg0,long arg1,boolean arg2) throws Exception{
       System.out.println(arg0.getValue());
   }

   @Override
    public void onEvent(LongEvent arg0) throws Exception{
       System.out.println(arg0.getValue());
    }
}
