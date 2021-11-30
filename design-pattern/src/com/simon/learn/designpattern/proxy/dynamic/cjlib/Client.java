package com.simon.learn.designpattern.proxy.dynamic.cjlib;

/**
 * @author simon.wei
 */
public class Client {
    public static void main(String[] args) {
        BuyProxy proxy = new BuyProxy();

        Mike mike = (Mike)proxy.getInstance(new Mike().getClass());

        mike.buyCar();
        mike.buyInsurance();

    }
}
