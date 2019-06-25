package com.demo.base.io.aio;

/**
 * Created by Krystal on 2019/5/6.
 */
public class TimeClient {
    public static void main(String[] args){
        new Thread(new AsyncTimeClientHandler("127.0.0.1",8080),"AIO-AsyncTimeClientHandler-001").start();
    }
}
