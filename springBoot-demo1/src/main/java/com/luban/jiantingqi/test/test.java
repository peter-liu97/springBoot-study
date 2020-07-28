package com.luban.jiantingqi.test;



public class test {
    public static void main(String[] args) {
        ListManager.addEvent(new AListener() );

        ListManager.pushEvent(new AEvent());
    }
}
