package com.vincent.eventbus.utils;


import android.content.Context;

import com.vincent.eventbus3.MyEventBusIndex;

import org.greenrobot.eventbus.EventBus;


/**
 * description ：
 * project name：EventBus3
 * author : Vincent
 * creation date: 2017/3/13 23:31
 *
 * @version 1.0
 */

public class EventBusUtils {

    private static EventBus eventBus = EventBus.builder().addIndex(new MyEventBusIndex()).build();;

    //EventBus mEventBus = EventBus.builder().addIndex(new MyEventBusIndex()).build();
    //EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();


    /**
     * 初始化
     * @return
     */
    public static synchronized EventBus getEventBus() {
        if(eventBus == null){
            //初始化的三种方式
//            eventBus = EventBus.getDefault();
            /*EventBus默认有一个单例，可以通过getDefault()获取，也可以通过EventBus.builder()构造自定义的EventBus，比如要应用我们生成好的索引时：*/
            eventBus = EventBus.builder().addIndex(new MyEventBusIndex()).build();
            /*如果想把自定义的设置应用到EventBus默认的单例中，则可以用installDefaultEventBus()方法：*/
//            eventBus = EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();
        }
        return eventBus;
    }

    /**
     * 注册 在onCreate方法或者onStart方法中
     * @param context
     */
    public static void register(Context context){
        if(!eventBus.isRegistered(context)){
            eventBus.register(context);
        }
    }

    /**
     * 解注册 在onDestory 或者onStop中
     * @param context
     */
    public static void unRegister(Context context){
        if(eventBus.isRegistered(context)){
            eventBus.unregister(context);
        }
    }

    /**
     * 传递对象
     * @param o
     */
    public static void post(Object o){
        eventBus.post(o);
    }
}
