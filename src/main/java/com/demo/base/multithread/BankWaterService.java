package com.demo.base.multithread;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Krystal on 2019/3/29.
 */
public class BankWaterService implements Runnable {
    private CyclicBarrier c = new CyclicBarrier(4,this);

    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<String,Integer>();
    private void count(){
        for (int i = 0;i < 4 ;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                    try{
                        c.await();

                    }catch (InterruptedException|BrokenBarrierException e){
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    @Override
    public void run(){
        int result = 0;
        for(Map.Entry<String,Integer> sheet:sheetBankWaterCount.entrySet()){
            result+=sheet.getValue();
            System.out.println(sheet.getKey()+":"+sheet.getValue());
        }
        sheetBankWaterCount.put("result",result);
        System.out.println(result);
    }

    public static void main(String[] args){
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
