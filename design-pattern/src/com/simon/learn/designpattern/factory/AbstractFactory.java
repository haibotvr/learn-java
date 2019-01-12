package com.simon.learn.designpattern.factory;

import com.simon.learn.designpattern.factory.pojo.Cpu;
import com.simon.learn.designpattern.factory.pojo.Motherboard;

public interface AbstractFactory {

    /**
     * 创建cpu对象
     */
    Cpu createCpu();

    /**
     * 创建主板对象
     */
    Motherboard createMotherboard();

}
