package com.next;

import org.openjdk.jol.info.ClassLayout;

public class Jol {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(7000);
        Object o = new Object();
//        System.out.println("预计是无锁状态,");
//        System.out.println(String.valueOf( ClassLayout.parseInstance(o).toPrintable()));


        System.out.println("预计是可偏向状态101");
        System.out.println(String.valueOf( ClassLayout.parseInstance(o).toPrintable()));
        new Thread(()->{
            synchronized (o){
                System.out.println("预计是偏向锁101 00001111");
                System.out.println(String.valueOf( ClassLayout.parseInstance(o).toPrintable()));
            }
        }).start();


//        Thread.sleep(30);
        new Thread(()->{
            synchronized (o){
                System.out.println("预计是轻量级锁000");
                System.out.println(String.valueOf( ClassLayout.parseInstance(o).toPrintable()));
            }
        }).start();
        Thread.sleep(30);
        new Thread(()->{
            synchronized (o){
                System.out.println("预计是重量级010");
                System.out.println(String.valueOf( ClassLayout.parseInstance(o).toPrintable()));
            }
        }).start();
    }
}
