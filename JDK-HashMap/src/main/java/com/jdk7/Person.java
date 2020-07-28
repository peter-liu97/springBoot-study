package com.jdk7;

import sun.misc.Unsafe;


import java.lang.reflect.Field;

public class Person {

    private int i = 0;
    private static sun.misc.Unsafe UNSAFE;
    private static long I_OFFSET;

    private String[] talbe = {"1", "2", "3", "4"};

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);

            I_OFFSET = UNSAFE.objectFieldOffset(Person.class.getDeclaredField("i"));


        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        final Person person  = new Person();

//
        int ss = UNSAFE.arrayIndexScale(String[].class);  //
//        int base = UNSAFE.arrayBaseOffset(String[].class);
//        System.out.println(UNSAFE.getObject(person.talbe, base+2*ns));

        int j = 3;
        System.out.println(j << (31 - Integer.numberOfLeadingZeros(ss)));
        System.out.println(j*ss);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
////                    person.i++;
//
//                    // 2===3
//                   boolean b= UNSAFE.compareAndSwapInt(person, I_OFFSET, person.i, person.i+1);
//                    if (b) {
//                        // ..
//                        System.out.println(UNSAFE.getIntVolatile(person, I_OFFSET));// 4
//                    }
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    // 3===4
//                    boolean b = UNSAFE.compareAndSwapInt(person, I_OFFSET, person.i, person.i+1);
//                    if (b) {
//                        System.out.println(UNSAFE.getIntVolatile(person, I_OFFSET));  // 4
//                    }
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }

}
