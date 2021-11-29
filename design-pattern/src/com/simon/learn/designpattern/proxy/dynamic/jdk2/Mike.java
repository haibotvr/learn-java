package com.simon.learn.designpattern.proxy.dynamic.jdk2;

/**
 * @author simon.wei
 */
public class Mike implements IPerson {

    @Override
    public void buyCar() {
        System.out.println("buy audi");
    }

    @Override
    public void buyInsurance() {
        System.out.println("10W");
    }
}
