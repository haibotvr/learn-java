package com.simon.learn.designpattern.decorator.concrete;

/**
 * @author simon.wei
 */
public class Client {

    public static void main(String[] args) {

        BatterCake battercake;

        battercake = new Base();

        battercake = new EggDecorator(battercake);

        battercake = new EggDecorator(battercake);

        battercake = new SauageDecorator(battercake);

        System.out.println(battercake.msg() + ",总价" + battercake.price());
    }

}
