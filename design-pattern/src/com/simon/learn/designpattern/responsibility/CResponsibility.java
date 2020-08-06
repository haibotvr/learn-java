package com.simon.learn.designpattern.responsibility;

import com.simon.learn.designpattern.responsibility.pojo.Trigger;

/**
 * @author simon.wei
 */
public class CResponsibility implements IResponsibility {

    @Override
    public void doSomething(Trigger trigger, IResponsibility iResponsibility) {
        if("C".equals(trigger.getCondition())) {
            System.out.println("C");
        }
        //回调，将参数传递给下一个责任模型
        iResponsibility.doSomething(trigger, iResponsibility);
    }
}
