package com.simon.learn.designpattern.observation;

/**
 * @author simon.wei
 */
public interface Observed {

    void notify(String message);

    void add(Observer observer);

    void del(Observer observer);

}
