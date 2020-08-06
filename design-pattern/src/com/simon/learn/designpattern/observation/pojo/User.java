package com.simon.learn.designpattern.observation.pojo;

import com.simon.learn.designpattern.observation.Observer;

/**
 * @author simon.wei
 */
public class User implements Observer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + ":" + message);
    }

    public User(String name) {
        this.name = name;
    }

}
