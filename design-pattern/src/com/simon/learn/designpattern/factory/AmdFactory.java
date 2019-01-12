package com.simon.learn.designpattern.factory;

import com.simon.learn.designpattern.factory.pojo.AmdCpu;
import com.simon.learn.designpattern.factory.pojo.AmdMotherboard;
import com.simon.learn.designpattern.factory.pojo.Cpu;
import com.simon.learn.designpattern.factory.pojo.Motherboard;

/**
 * @author simon.wei
 */
public class AmdFactory implements AbstractFactory{

    @Override
    public Cpu createCpu() {
        return new AmdCpu(938);
    }

    @Override
    public Motherboard createMotherboard() {
        return new AmdMotherboard(938);
    }
}
