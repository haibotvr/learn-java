package com.simon.learn.headfirstjava.extend;

/**
 * @author simon.wei
 */
public class Client {

    public static void main(String[] args) {
        Foo a = new Foo();
        a.setName();
        a.printName();

        Foo b = new Boo();
        b.printName();
    }

}
