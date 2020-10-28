package com.simon.learn.designpattern.prototype.general;

/**
 * @author simon.wei
 */
public class Client {

    public static void main(String[] args) {
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAge(18);
        prototype.setName("simon");
        System.out.println(prototype);
        Object clone = prototype.clone();
        System.out.println(clone);
    }

}
