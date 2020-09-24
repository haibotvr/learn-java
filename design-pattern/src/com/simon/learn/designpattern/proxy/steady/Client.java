package com.simon.learn.designpattern.proxy.steady;

/**
 * @author simon.wei
 */
public class Client {

    /**
     * 为其它对象提供一种代理，以控制对这个对象的访问
     * 代理对象在客户端和目标对象之间起到中介作用
     * 属于结构设计模式
     */
    public static void main(String[] args) {

        IPerson person  = new Fathor(new Son());

        person.love();
    }
}
