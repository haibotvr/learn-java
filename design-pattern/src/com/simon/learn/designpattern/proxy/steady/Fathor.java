package com.simon.learn.designpattern.proxy.steady;

/**
 * @author simon.wei
 */
public class Fathor implements IPerson {

    private Son son;

    public Fathor(Son son) {
        this.son = son;
    }

    @Override
    public void love() {
        before();
        son.love();
        after();
    }

    public void before() {
        System.out.println("开始物色");
    }

    public void after() {
        System.out.println("开始交往");
    }
}
