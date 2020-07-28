package com.jdk7;

import java.util.Stack;

public class ThreadDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <10000 ; i++) {
            stack.push(i);
        }

        Draw draw = new Draw(stack);
        Thread thread1 = new Thread(draw);
        Thread thread2 = new Thread(draw);
        Thread thread3 = new Thread(draw);
        Thread thread5 = new Thread(draw);
        Thread thread4 = new Thread(draw);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }




}
