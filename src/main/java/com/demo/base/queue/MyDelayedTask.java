package com.demo.base.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Krystal on 2019/6/13.
 */
public class MyDelayedTask implements Delayed {
    private String name;
    private long start = System.currentTimeMillis();
    private long time;
    public MyDelayedTask(String name,long time){
        this.name = name;
        this.time = time;
    }

    @Override
    public long getDelay(TimeUnit unit){
        return unit.convert((start+time) - System.currentTimeMillis(),TimeUnit.MICROSECONDS);
    }

    @Override
    public int compareTo(Delayed o){
        MyDelayedTask ol = (MyDelayedTask)o;
        return (int)(this.getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS));
    }


}
