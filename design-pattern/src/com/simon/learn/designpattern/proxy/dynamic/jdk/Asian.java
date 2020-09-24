package com.simon.learn.designpattern.proxy.dynamic.jdk;

/**
 * @author simon.wei
 */
public class Asian implements Skin {

    @Override
    public void color() {
        System.out.println("亚洲人是黄色皮肤");
    }
}
