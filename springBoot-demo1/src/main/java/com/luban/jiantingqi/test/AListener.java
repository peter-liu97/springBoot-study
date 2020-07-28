package com.luban.jiantingqi.test;


public class AListener implements ApplicationListener<AEvent>{
    @Override
    public void onEvnt(AEvent aEvent) {
        System.out.println("监听到了A事件");
    }
}
