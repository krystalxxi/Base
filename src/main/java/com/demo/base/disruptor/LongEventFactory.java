package com.demo.base.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by Krystal on 2019/6/25.
 * EventFactory负责实例化Event对象
 */
public class LongEventFactory implements EventFactory{
    @Override
    public Object newInstance(){
        return new LongEvent();
    }
}
