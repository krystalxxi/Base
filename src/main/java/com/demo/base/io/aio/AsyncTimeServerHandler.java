package com.demo.base.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Krystal on 2019/5/6.
 */
public class AsyncTimeServerHandler implements Runnable {
    private int port;
    CountDownLatch latch;
    AsynchronousServerSocketChannel asynchronousServerSocketChannel;
    public AsyncTimeServerHandler(int port){
        this.port = port;
        try {
            asynchronousServerSocketChannel  = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        latch = new CountDownLatch(1);
        doAccept();
        try {
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void doAccept(){
        asynchronousServerSocketChannel.accept(this,new AcceptCompletionHandler());
    }
}
