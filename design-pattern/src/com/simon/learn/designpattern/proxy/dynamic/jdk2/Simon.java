package com.simon.learn.designpattern.proxy.dynamic.jdk2;

/**
 * @author simon.wei
 */
public class Simon implements IPerson {

    @Override
    public void buyCar() {
        System.out.println("buy benz");
    }

    @Override
    public void buyInsurance() {
        System.out.println("15W");
    }
}
