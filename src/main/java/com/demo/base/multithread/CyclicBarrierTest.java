package com.demo.base.multithread;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Krystal on 2019/3/29.
 * 可循环使用的屏障
 */
public class CyclicBarrierTest {
    static int count = 5;
    static CyclicBarrier c = new CyclicBarrier(count);

    public static void main(String[] args) {
        for (int i = 0;i < count; i++ ){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 每个线程调用await方法告诉CyclicBarrier，我已经到达了屏障，然后当前线程被阻塞。
                        c.await();

                    } catch (Exception e) {

                    }
                }
            }).start();
            System.out.println(i);
        }


        System.out.println("done");
    }
}
