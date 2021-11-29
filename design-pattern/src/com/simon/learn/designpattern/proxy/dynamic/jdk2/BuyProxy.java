package com.simon.learn.designpattern.proxy.dynamic.jdk2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author simon.wei
 */
public class BuyProxy implements InvocationHandler {

    private IPerson iPerson;

    public IPerson getInstance(IPerson iPerson) {
        this.iPerson = iPerson;
        Class<?> clazz = iPerson.getClass();
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.iPerson, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("end ...");
    }

    private void before() {
        System.out.println("start ...");
    }
}
