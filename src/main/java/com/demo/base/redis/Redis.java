package com.demo.base.redis;

import redis.clients.jedis.*;

import java.util.Map;

/**
 * Created by Krystal on 2019/5/10.
 * redis 主从复制模式连接
 */
public class Redis {
    private Jedis jedis;
    public Redis(){
        jedis = new Jedis("127.0.0.1",7001);
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
        Redis redis = new Redis();
        redis.set("test_1001","1001");
        String value = redis.get("test_1001");
        System.out.println(value);
    }
}
