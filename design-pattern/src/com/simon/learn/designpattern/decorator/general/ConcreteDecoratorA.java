package com.simon.learn.designpattern.decorator.general;

/**
 * @author simon.wei
 */
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        this.operationFirst();
        super.operation();
        this.operationLast();
    }

    private void operationFirst() {

    }

    private void operationLast() {

    }
}
