package com.jdk7;

import java.util.Stack;

public class Draw implements Runnable {
    Stack<Integer> stack ;
    public Draw(Stack stack){
        this.stack=stack;
    }
    @Override
    public void run() {
        while (!this.stack.isEmpty()){
            synchronized (this){
                notify();
                System.out.println(Thread.currentThread().getName()+" "+this.stack.pop());
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
