package com.luban.jiantingqi.test;



public interface ApplicationListener< E extends ApplicationEvnt> {
    void onEvnt(E e);
}
