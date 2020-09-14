package com.simon.learn.designpattern.factory.pojo;

import com.simon.learn.designpattern.factory.ICourse;

/**
 * @author simon.wei
 */
public class PythonCourse implements ICourse {

    @Override
    public void play() {
        System.out.println("学习Python课程");
    }
}
