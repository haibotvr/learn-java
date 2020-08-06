package com.simon.learn.designpattern.responsibility;

import com.simon.learn.designpattern.responsibility.pojo.*;

/**
 * @author simon.wei
 */
public class Client {

    /**
     * 责任链模式在面向对象程式设计里是一种软件设计模式，它包含了一些命令对象和一系列的处理对象。
     * 每一个处理对象决定它能处理哪些命令对象，它也知道如何将它不能处理的命令对象传递给该链中的下一个处理对象。
     * 该模式还描述了往该处理链的末尾添加新的处理对象的方法。
     * 1、抽象责任对象
     * 2、具体责任对象--处理具体业务
     * 3、责任链对象--将责任链各个点用链表的形式保存起来，形成一个完整的责任链模型
     */

    public static void main(String[] args) {
        Trigger trigger = new Trigger("C");
        ResponsibilityChain chain = new ResponsibilityChain();
        chain.add(new AResponsibility())
                .add(new BResponsibility())
                .add(new CResponsibility());
        chain.doSomething(trigger, chain);
    }
}
