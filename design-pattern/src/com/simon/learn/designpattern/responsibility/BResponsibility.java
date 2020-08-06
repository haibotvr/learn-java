package com.simon.learn.designpattern.responsibility;

import com.simon.learn.designpattern.responsibility.pojo.Trigger;

/**
 * @author simon.wei
 */
public class BResponsibility implements IResponsibility {

    @Override
    public void doSomething(Trigger trigger, IResponsibility iResponsibility) {
        if("B".equals(trigger.getCondition())) {
            System.out.println("B");
        }
        //回调，将参数传递给下一个责任模型
        iResponsibility.doSomething(trigger, iResponsibility);
    }
}
