package com.luban.jiantingqi.listener;


import com.luban.jiantingqi.evnt.ApplicationEvnt;

public interface ApplicationListener< E extends ApplicationEvnt> {


//    void  onEvnts(String ... a);

    void onEvnt(E e);
}
