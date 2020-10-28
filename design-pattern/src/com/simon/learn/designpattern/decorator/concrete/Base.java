package com.simon.learn.designpattern.decorator.concrete;

/**
 * @author simon.wei
 */
public class Base extends BatterCake {

    @Override
    protected String msg() {
        return "煎饼";
    }

    @Override
    protected int price() {
        return 5;
    }
}
