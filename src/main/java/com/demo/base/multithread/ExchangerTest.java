package com.demo.base.multithread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Krystal on 2019/3/29.
 * Exchanger(交换者)是一个用于线程间协作的工具类。用于线程间的数据交换。
 * 它提供一个同步点，在这个同步点，两个线程可以交换彼此的数据。
 * 如果第一个线程先执行exchange()方法，它会一直等待第二个线程也执行exchange方法，当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产出来的数据传递给对方。
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);
    public static void main(String[] args){
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";
                    exgr.exchange(A);
                }catch (InterruptedException e){

                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try{
                   String B = "银行流水B";
                   String A = exgr.exchange(B);
                   System.out.println("A和B数据是否一致:"+A.equals(B)+",A录入的是："+A+",B录入的是："+B);
                }catch (InterruptedException e){

                }
            }
        });

       threadPool.shutdown();
    }
}
