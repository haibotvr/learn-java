package com.simon.learn.designpattern.factory;

import com.simon.learn.designpattern.factory.pojo.Cpu;
import com.simon.learn.designpattern.factory.pojo.Motherboard;

/**
 * @author simon.wei
 */
public class ComputerEngineer {

    private Cpu cpu = null;

    private Motherboard motherboard = null;

    public void makeComputer(AbstractFactory factory){

        prepareHardwares(factory);

    }

    private void prepareHardwares(AbstractFactory factory) {

        //工厂中获取
        this.cpu = factory.createCpu();
        this.motherboard = factory.createMotherboard();

        this.cpu.calculate();
        this.motherboard.installCpu();

    }
}
