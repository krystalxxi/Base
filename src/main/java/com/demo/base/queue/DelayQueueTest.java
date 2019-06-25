package com.demo.base.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * Created by Krystal on 2019/6/13.
 */
public class DelayQueueTest {
    private static DelayQueue delayQueue = new DelayQueue();
    public static void main(String[] args) throws InterruptedException{
        new Thread(new Runnable(){
            @Override
            public void run(){
                // DelayQueue内部的实现使用了一个优先队列。当调用DelayQueue的offer方法时，把Delayed对象加入到优先队列q中.
                delayQueue.offer(new MyDelayedTask("task1",10000));
                delayQueue.offer(new MyDelayedTask("task2",3900));
                delayQueue.offer(new MyDelayedTask("task3",1900));
            }
        }).start();
        while (true){
            // DelayQueue的take方法，把优先队列q的first拿出来（peek），如果没有达到延时阀值，则进行await处理
            Delayed take = delayQueue.take();
            System.out.println(take);
        }
    }
}
