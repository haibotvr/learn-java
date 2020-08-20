package com.simon.learn.designpattern.strategy;

/**
 * @author simon.wei
 */
public class TrainStrategy implements TravelStrategy {

    @Override
    public void travel() {
        System.out.println("乘坐火车");
    }
}
