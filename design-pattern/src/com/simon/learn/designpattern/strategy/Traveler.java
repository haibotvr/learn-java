package com.simon.learn.designpattern.strategy;

/**
 * @author simon.wei
 */
public class Traveler {

    TravelStrategy strategy;

    public void setStrategy(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public void travel() {
        strategy.travel();
    }

    public static void main(String[] args) {
        Traveler traveler = new Traveler();
        traveler.setStrategy(new AirStrategy());
        traveler.travel();
    }
}
