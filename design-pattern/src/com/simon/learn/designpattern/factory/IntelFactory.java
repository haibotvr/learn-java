package com.simon.learn.designpattern.factory;


import com.simon.learn.designpattern.factory.pojo.Cpu;
import com.simon.learn.designpattern.factory.pojo.IntelCpu;
import com.simon.learn.designpattern.factory.pojo.IntelMotherboard;
import com.simon.learn.designpattern.factory.pojo.Motherboard;

/**
 * @author simon.wei
 */
public class IntelFactory implements AbstractFactory{

    @Override
    public Cpu createCpu() {
        return new IntelCpu(755);
    }

    @Override
    public Motherboard createMotherboard() {
        return new IntelMotherboard(755);
    }
}
