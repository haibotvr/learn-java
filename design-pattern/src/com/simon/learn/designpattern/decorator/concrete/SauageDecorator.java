package com.simon.learn.designpattern.decorator.concrete;

/**
 * @author simon.wei
 */
public class SauageDecorator extends BatterCakeDecorator {

    public SauageDecorator(BatterCake battercake) {
        super(battercake);
    }

    @Override
    protected String msg() {
        return super.msg() + "1跟香肠";
    }

    @Override
    protected int price() {
        return super.price() + 2;
    }
}
