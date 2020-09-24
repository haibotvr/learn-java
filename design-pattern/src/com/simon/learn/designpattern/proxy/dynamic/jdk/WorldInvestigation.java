package com.simon.learn.designpattern.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author simon.wei
 */
public class WorldInvestigation implements InvocationHandler {

    private Object target;

    public WorldInvestigation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调查开始,部门是:" + this.getClass().getSimpleName());
        method.invoke(target, args);
        System.out.println("调查结束");
        return null;
    }
}
