package com.demo.base.disruptor;

import com.lmax.disruptor.*;

import java.util.concurrent.*;

/**
 * Created by Krystal on 2019/6/25.
 */
public class LongEventEventProcessorMain {
    public static void main(String[] args) throws Exception {
        int BUFFER_SIZE=1024;
        int THREAD_NUMBERS=4;

        final RingBuffer<LongEvent> ringBuffer = RingBuffer.createSingleProducer(new EventFactory<LongEvent>() {
            @Override
            public LongEvent newInstance() {
                return new LongEvent();
            }
        },BUFFER_SIZE,new YieldingWaitStrategy());
        // 创建线程池
        ExecutorService executors = new ThreadPoolExecutor(THREAD_NUMBERS,10,30,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(100));

        // 创建SequenceBarrier
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

        // 创建消息处理器
        BatchEventProcessor<LongEvent> processor = new BatchEventProcessor<>(ringBuffer,sequenceBarrier,new LongEventHandler());

        ringBuffer.addGatingSequences(processor.getSequence());

        //把消息处理器提交到线程池
        executors.submit(processor);

        Future future = executors.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception{
                long seq;
                for (int i = 0;i < 100000; i++){
                    seq = ringBuffer.next();
                    ringBuffer.get(seq).setValue(i);
                    ringBuffer.publish(seq);
                }
                return null;
            }
        });
        future.get();
        Thread.sleep(1000);
        processor.halt();
        executors.shutdown();

    }

}
