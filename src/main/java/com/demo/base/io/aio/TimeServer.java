package com.demo.base.io.aio;

import java.io.IOException;

/**
 * Created by Krystal on 2019/5/6.
 */
public class TimeServer {
    public static void main(String[] args) throws IOException{
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(8080);
        new Thread(timeServer,"AIO-AsyncTimeServerHandler-001").start();
    }
}
