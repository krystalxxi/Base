package com.demo.base.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Krystal on 2019/3/29.
 */
public class CountDownLatchTest {
    static int count = 5;
    static CountDownLatch countDownLatch = new CountDownLatch(count);

    public static void main(String[] args) throws InterruptedException{
        for(int i = 0;i < count;i++ ) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    countDownLatch.countDown();
                }

            }).start();
            System.out.println(i);
        }
        // 阻塞当前线程，直到N变成零
        countDownLatch.await();
        System.out.println("done");

    }
}
