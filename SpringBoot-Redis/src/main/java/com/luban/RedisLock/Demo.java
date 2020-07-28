package com.luban.RedisLock;

import com.luban.pojo.R;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;


public class Demo {
    private int COUNT = 10;


    class TicketsRunBle implements Runnable {

        private Redisson redisson;
//        Lock lock = new RedisLock();
        ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            while (COUNT > 0) {
//                RLock lock1 = redisson.getLock("{taibai0}:100001320055");
//                RLock lock2 = redisson.getLock("{taibai0}:100001320055");
//                RLock lock3 = redisson.getLock("{taibai0}:100001320055");
//                RedissonRedLock redissonRedLock = new RedissonRedLock(lock1, lock2, lock3);
//                redissonRedLock.lock();

                lock.lock();

//                try {
                    if (COUNT > 0) {
                        System.out.println(Thread.currentThread().getName() + "售出第" + COUNT-- + "张票");

                        try {
                            Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 3000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
                lock.unlock();
//                }
            }
//
//            if(COUNT>0){
//                try {
//                    Thread.sleep(100);
//                    System.out.println(Thread.currentThread().getName() + "售出第" + COUNT-- + "张票");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

    @Test
    public void test() {
        TicketsRunBle ticketsRunBle=new TicketsRunBle();
            Thread thread1 = new Thread(ticketsRunBle,"thread1");
            Thread thread2 = new Thread(ticketsRunBle,"thread2");
            Thread thread3 = new Thread(ticketsRunBle,"thread3");
            Thread thread4 = new Thread(ticketsRunBle,"thread4");
            Thread thread5 = new Thread(ticketsRunBle,"thread5");

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}


