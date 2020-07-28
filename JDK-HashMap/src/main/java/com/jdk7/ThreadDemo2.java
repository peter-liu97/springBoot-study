package com.jdk7;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo2 {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Condition condition = lock.newCondition();
        Condition condition2 = lock.newCondition();

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                lock.lock();

                try {
                    if (stack.peek() % 2 != 0) {
                        condition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "  " + stack.pop());
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(() -> {

            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                lock.lock();

                try {
                    if (stack.peek() % 2 != 1) {
                        condition2.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "  " + stack.pop());
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();

    }
}
