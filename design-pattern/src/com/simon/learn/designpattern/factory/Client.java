package com.simon.learn.designpattern.factory;

/**
 * @author simon.wei
 */
public class Client {

    public static void main(String[] args) {

        //创建装机工程师对象
        ComputerEngineer engineer = new ComputerEngineer();
        //客户选择产品对象
        AbstractFactory factory = new AmdFactory();
        //装机工程师组装
        engineer.makeComputer(factory);

    }

}
