package com.demo.base.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Krystal on 2019/3/29.
 * 信号量用来控制同时访问特定资源的线程数量，它通过协调各个线程，以保证合理的使用公共资源
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore semaphore = new Semaphore(10);
    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(semaphore.getQueueLength());
                        semaphore.release();
                    } catch (InterruptedException e) {

                    }
                }
            });
        }
        threadPool.shutdown();
    }

}
