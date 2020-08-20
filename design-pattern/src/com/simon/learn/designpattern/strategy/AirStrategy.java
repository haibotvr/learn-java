package com.simon.learn.designpattern.strategy;

/**
 * @author simon.wei
 */
public class AirStrategy implements TravelStrategy {

    @Override
    public void travel() {
        System.out.println("乘坐飞机");
    }
}
