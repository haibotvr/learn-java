package com.simon.learn.designpattern.factory;

/**
 * @author simon.wei
 */
public class CourseFactory {

    public static ICourse create(Class clazz) {
        try {
            return (ICourse) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
