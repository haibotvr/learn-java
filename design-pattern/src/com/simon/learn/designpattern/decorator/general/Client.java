package com.simon.learn.designpattern.decorator.general;

import com.simon.learn.designpattern.decorator.general.*;

/**
 * @author simon.wei
 */
public class Client {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decoratorA = new ConcreteDecoratorA(component);
        decoratorA.operation();

        Decorator decoratorB = new ConcreteDecoratorB(decoratorA);
        decoratorB.operation();
    }
}
