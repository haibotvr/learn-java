package com.simon.learn.designpattern.factory.pojo;

/**
 * AmdCpu类
 *
 * @author simon.wei
 */
public class AmdCpu implements Cpu{

    private int pins;

    public AmdCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("AMD CPU的针脚数：" + pins);
    }
}
