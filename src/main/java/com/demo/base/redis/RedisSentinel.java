package com.demo.base.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Krystal on 2019/5/10.
 * redis 主从复制模式连接
 */
public class RedisSentinel {
    String masterName = "mymaster";
    Set<String> sentinelSet = new HashSet<String>();
    Jedis jedis = null;
    public RedisSentinel(){
        // sentinelSet.add("127.0.0.1:27001");
        sentinelSet.add("127.0.0.1:27002");
        JedisSentinelPool sentinelPool = new JedisSentinelPool(masterName,sentinelSet);
        jedis = sentinelPool.getResource();
    }
    /**
     * 获取redis中指定key的值，value类型为String使用此方法
     * @param key
     * @return
     */
    public String get(String key){
        return jedis.get(key);
    }

    /**
     * 设置redis中指定key的值，value类型为String的使用此方法
     * @param key
     * @param value
     */
    public void set(String key,String value){
        jedis.set(key,value);
    }

    /**
     * 获取redis中指定key的值，对应的value，value类型为map的使用此方法
     * @param key
     * @return
     */
    public Map<String,String> getMap(String key){
       return jedis.hgetAll(key);
    }

    /**
     * 删除redis中指定key的值
     * @param key
     */
    public void del(String key){
        jedis.del(key);
    }

    public  static void main(String[] args){
        RedisSentinel redis = new RedisSentinel();
        redis.set("test_1005","1005");
        String value = redis.get("test_1005");
        System.out.println(value);
    }
}
