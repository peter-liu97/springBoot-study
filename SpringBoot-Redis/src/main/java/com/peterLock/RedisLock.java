package com.peterLock;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.UUID;

public class RedisLock {

    @Test
    public void lock(){
        Jedis jedis = new Jedis("121.199.65.11",6379);
        //保证原子性
        SetParams setParams = new SetParams();
        setParams.ex(6);  //设置值的同时 设置过期时间
        setParams.nx();
        String str = UUID.randomUUID().toString();
        String lock = jedis.set("lock", str,setParams);
        System.out.println(lock);
    }
}
