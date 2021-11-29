package com.simon.learn.designpattern.proxy.dynamic.jdk2;

/**
 * @author simon.wei
 */
public class Client {
    public static void main(String[] args) {
        BuyProxy proxy = new BuyProxy();

        IPerson iPerson = proxy.getInstance(new Mike());
        iPerson.buyCar();
        iPerson.buyInsurance();

        iPerson = proxy.getInstance(new Simon());
        iPerson.buyCar();
        iPerson.buyInsurance();
    }
}
