package com.luban.lambda;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;

public class Person {

    private void test(String str,PersonCallBack personCallBack){
        System.out.println(str);
        personCallBack.callBack();
    }

    public static void main(String[] args) {
//        new Person().test("zs", new PersonCallBack() {
//            @Override
//            public void callBack() {
//                //.....
//                System.out.println("callBack");
//            }
//        });
        /**
         * lambda
         *    () 内写的是型参 {}内是方法体
         *
         *    接口里面只有一个方法 lambda 是直接把方法实现了  底层并不是一个类实现了该方法
         */

//        PersonCallBack personCallBack = ()->{
//            System.out.println();
//        };
//        new Person().test("zs",personCallBack);
        new Person().test("zs", () -> {
            System.out.println("callBack");
        });

        /**
         *
         */
        Consumer consumer = System.out::println;
        consumer.accept(122);
        /**
         * 函数式接口 ： 一个接口里面只有一个方法
         * @FunctionalInterface 声明函数式接口
         */
    }


    public void OptionalTest( String name){
        Optional optional = Optional.ofNullable(name);
        optional.get();
    }
}
