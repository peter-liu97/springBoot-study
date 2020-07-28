package com.luban.testJedis;

import io.lettuce.core.RedisClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        SetParams setParams =new SetParams();
        setParams.ex(6);
        setParams.nx();
        String s = UUID.randomUUID().toString();
        String lock = jedis.set("lock", s, setParams);
        System.out.println(lock);
    }

    @org.junit.Test
    public void test(){
        Jedis jedis = new Jedis("127.0.0.1", 8000);
        jedis.auth("123456");
        for (int i =50000 ; i <100000 ; i++) {
            jedis.set("key"+i,"v"+i);
        }
    }

    @org.junit.Test
    public void test1(){
        System.out.println("将下面的分数化简，如果是假分数，化简为带分数");
        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random()*100+1);
            int b = (int) (Math.random()*100+1);
//            int a= 120;
//            int b =100;
            System.out.print(a+"/"+b+"   ");
//            int t=2;
//            while (t<=bijiao(a,b)){
//                if (a%t==0&&b%t==0){
//                    a=a/t;
//                    b=b/t;
//                    t=1;
//                }
//                t++;
//            }
//            System.out.println(a/b+"又"+a%b+"/"+b);
        }
    }
    public int bijiao(int a , int b){
        if (a<b||a==b){
            return a;
        }else return b;
    }
}
