package com.simon.learn.designpattern.decorator.concrete;

/**
 * @author simon.wei
 */
public class EggDecorator extends BatterCakeDecorator {

    public EggDecorator(BatterCake battercake) {
        super(battercake);
    }

    @Override
    protected String msg() {
        return super.msg() + "1个鸡蛋";
    }

    @Override
    protected int price() {
        return super.price() + 1;
    }
}
