package com.luban.jiantingqi.listener;


import com.luban.jiantingqi.evnt.AEvent;

public class AAListener implements ApplicationListener<AEvent> {
    @Override
    public void onEvnt(AEvent aEvent) {
        System.out.println("AA也监听到了");
    }
}
