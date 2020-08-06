package com.simon.learn.designpattern.observation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author simon.wei
 */
public class MessageOpt implements Observed {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void notify(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void del(Observer observer) {
        if(Objects.nonNull(observer)) {
            if(observers.contains(observer)) {
                observers.remove(observer);
            }
        }
    }
}
