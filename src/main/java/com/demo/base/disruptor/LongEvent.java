package com.demo.base.disruptor;

/**
 * Created by Krystal on 2019/6/25.
 * Event类
 */
public class LongEvent {
    private long value;
    public long getValue(){
        return value;
    }
    public void setValue(long value){
       this.value = value;
    }
}
