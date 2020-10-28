package com.simon.learn.designpattern.decorator.general;

/**
 * @author simon.wei
 */
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
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
