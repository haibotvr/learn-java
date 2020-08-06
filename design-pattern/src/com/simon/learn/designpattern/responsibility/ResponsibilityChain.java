package com.simon.learn.designpattern.responsibility;

import com.simon.learn.designpattern.responsibility.pojo.Trigger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author simon.wei
 */
public class ResponsibilityChain implements IResponsibility {

    private int index;

    private List<IResponsibility> responsibilities;

    public ResponsibilityChain() {
        this.index = 0;
        this.responsibilities = new ArrayList<>();
    }

    public ResponsibilityChain add(IResponsibility responsibility) {
        responsibilities.add(responsibility);
        return this;
    }

    @Override
    public void doSomething(Trigger trigger, IResponsibility iResponsibility) {
        //调用完成，退出
        if(index == responsibilities.size()) {
            return;
        }
        IResponsibility currentResponsibility = responsibilities.get(index);
        index++;
        currentResponsibility.doSomething(trigger, this);
    }
}
