package com.simon.learn.designpattern.observation;

import com.simon.learn.designpattern.observation.pojo.User;

/**
 * @author simon.wei
 */
public class Client {

    /***
     * 观察者模式
     *
     * 此模式包含4个角色
     * 1、抽象被观察者--主题
     * 2、抽象观察者--观察者
     * 3、被观察者--主题
     * 4、观察者--观察者
     *
     * 松耦合：改变主题或观察者其中一方，另一方不受影响
     */

    public static void main(String[] args) {
        Observed observed = new MessageOpt();
        Observer observer = new User("zhangsan");
        observed.add(observer);
        observed.add(new User("lisi"));
        observed.add(new User("wangwu"));
        observed.notify("收到了消息");
        observed.del(observer);
        observed.notify("第二条消息");
    }

}
