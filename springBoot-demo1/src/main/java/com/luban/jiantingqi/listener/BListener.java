package com.luban.jiantingqi.listener;


import com.luban.jiantingqi.evnt.BEvent;

public class BListener implements ApplicationListener<BEvent> {
    @Override
    public void onEvnt(BEvent bEvent) {
        System.out.println("监听到了B事件");
    }
}
