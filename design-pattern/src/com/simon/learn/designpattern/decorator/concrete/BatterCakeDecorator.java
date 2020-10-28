package com.simon.learn.designpattern.decorator.concrete;

/**
 * @author simon.wei
 */
public class BatterCakeDecorator extends BatterCake {

    private BatterCake battercake;

    public BatterCakeDecorator(BatterCake battercake) {
        this.battercake = battercake;
    }

    @Override
    protected String msg() {
        return this.battercake.msg();
    }

    @Override
    protected int price() {
        return this.battercake.price();
    }
}
