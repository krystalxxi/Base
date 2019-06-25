package com.demo.base.io.nio;

/**
 * Created by Krystal on 2019/5/6.
 */
public class TimeClient {
    public static void main(String[] args){
        new Thread(new TimeClientHandle("127.0.0.1",8080),"TimeClient-001").start();
    }
}
