package com.demo.base.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Krystal on 2019/7/1.
 */
public class RedisCluster {
    JedisCluster jedisCluster;

    @Before
    public void init(){
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.48.129",7000));
        nodes.add(new HostAndPort("192.168.48.129",7001));
        nodes.add(new HostAndPort("192.168.48.129",7002));
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxWaitMillis(1000);

        jedisCluster = new JedisCluster(nodes,jedisPoolConfig);

    }

    @Test
    public void testGet(){
        long startTime = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(500);
        for (int i = 0; i < 500; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                   String t = jedisCluster.get("test");
                   System.out.println(t);
                    countDownLatch.countDown();
                }
            }).start();
        }
        try{
            countDownLatch.await();

        }catch (InterruptedException e){
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long costTime = endTime -startTime;
        System.out.println("总耗时:"+costTime);
        jedisCluster.close();
    }

    @Test
    @Ignore
    public void testSet(){
        jedisCluster.set("test","1");
    }


}
