package com.luban.jiantingqi.listener;

import com.luban.jiantingqi.evnt.AEvent;

public class AListener  implements ApplicationListener<AEvent>{
    @Override
    public void onEvnt(AEvent aEvent) {
        System.out.println("监听到了A事件");
    }
}
