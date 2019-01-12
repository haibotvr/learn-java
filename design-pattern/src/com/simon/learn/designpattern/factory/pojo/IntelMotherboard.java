package com.simon.learn.designpattern.factory.pojo;

/**
 * @author simon.wei
 */
public class IntelMotherboard implements Motherboard {

    /**
     * cpu插孔数
     */
    private int cpuHoles = 0;

    public IntelMotherboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCpu() {

        System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);

    }
}
