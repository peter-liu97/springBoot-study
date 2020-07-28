package com.jdk7;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.concurrent.*;

public  class  ThreadPool {


    public static void main(String[] args) throws Exception {
        ExecutorService executorService = new ThreadPoolExecutor(2,4,20, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());


        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread thread1 = new Thread(() -> {
            System.out.println("thread 1 run");
            countDownLatch.countDown();
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("thread 2 run");
            countDownLatch.countDown();
        });

        class MyCallAble implements Callable{

            @Override
            public Object call() throws Exception {
                return "result";
            }
        }

        executorService.execute(thread2);
        Future<?> submit = null;
        MyCallAble myCallAble = new MyCallAble();
        Object call = myCallAble.call();
        System.out.println(call);
        try {
            submit = executorService.submit(myCallAble);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(submit.get());

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main 继续");


    }

    @Test
    public void test1() throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        new Thread(() -> {
            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
//        new Thread(()->{
//            try {
////                cyclicBarrier.await();
//                System.out.println(Thread.currentThread().getName());
//            } catch (InterruptedException | BrokenBarrierException e) {
//                e.printStackTrace();
//            }
//        }).start();
        cyclicBarrier.await();
        System.out.println("sssssss");


    }
}