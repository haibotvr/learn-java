package com.simon.learn.designpattern.factory;

import com.simon.learn.designpattern.factory.pojo.JavaCourse;
import com.simon.learn.designpattern.factory.pojo.PythonCourse;

/**
 * @author simon.wei
 */
public class CourseClient {

    /**
     * 简单工厂模式：产品的工厂
     */

    public static void main(String[] args) {
        ICourse course = CourseFactory.create(JavaCourse.class);
        course.play();
        course = CourseFactory.create(PythonCourse.class);
        course.play();
    }
}
