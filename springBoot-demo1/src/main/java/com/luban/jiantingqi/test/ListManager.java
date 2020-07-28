package com.luban.jiantingqi.test;


import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

//事件管理器
public class ListManager {
    static List<ApplicationListener<?>> applicationListeners = new ArrayList<>();
    //添加监听器
    public static void addEvent(ApplicationListener applicationListener){
        applicationListeners.add(applicationListener);
    }

    //  判断一下有哪些人对这个事件感兴趣
    public static void pushEvent(ApplicationEvnt evnt){
        for (ApplicationListener applicationListener:applicationListeners) {
            Class tClass = (Class)((ParameterizedType)applicationListener.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
            //判断一下泛型
//            tClass.isAssignableFrom()
            if (tClass.equals(evnt.getClass())) {
                applicationListener.onEvnt(evnt);
            }
        }
    }

}
