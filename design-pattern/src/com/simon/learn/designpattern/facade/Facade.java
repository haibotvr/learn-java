package com.simon.learn.designpattern.facade;

/**
 * @author simon.wei
 */
public class Facade {

    private SubSystemA a = new SubSystemA();

    private SubSystemB b = new SubSystemB();

    private SubSystemC c = new SubSystemC();

    public void doA() {
        a.execA();
    }

    public void doB() {
        b.execB();
    }

    public void doC() {
        c.execC();
    }
}
