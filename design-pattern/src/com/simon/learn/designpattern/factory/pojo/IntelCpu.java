package com.simon.learn.designpattern.factory.pojo;

/**
 * IntelCpu类
 *
 * @author simon.wei
 */
public class IntelCpu implements Cpu{

    /**
     * cpu针脚数
     */
    private int pins = 0;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {

        System.out.println("Intel CPU的针脚数：" + pins);

    }
}
