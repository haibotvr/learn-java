package com.simon.learn.designpattern.responsibility.pojo;

/**
 * @author simon.wei
 */
public class Trigger {

    private String condition;

    public Trigger(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
