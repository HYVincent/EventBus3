package com.vincent.eventbus;

/**
 * description ：
 * project name：EventBus3
 * author : Vincent
 * creation date: 2017/3/13 23:21
 *
 * @version 1.0
 */

public class EventMsg {

    private String msg;

    public EventMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
