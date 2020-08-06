package com.simon.learn.designpattern.responsibility;

import com.simon.learn.designpattern.responsibility.pojo.Trigger;

/**
 * @author simon.wei
 */
public interface IResponsibility {

    void doSomething(Trigger trigger, IResponsibility iResponsibility);

}
