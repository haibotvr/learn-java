package com.simon.learn.designpattern.factory.pojo;

import com.simon.learn.designpattern.factory.ICourse;

/**
 * @author simon.wei
 */
public class JavaCourse implements ICourse {

    @Override
    public void play() {
        System.out.println("学习Java课程");
    }
}
