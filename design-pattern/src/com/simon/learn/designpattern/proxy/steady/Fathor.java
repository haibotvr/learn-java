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
        System.out.println("开始物色");
        son.love();
        System.out.println("开始交往");
    }
}
