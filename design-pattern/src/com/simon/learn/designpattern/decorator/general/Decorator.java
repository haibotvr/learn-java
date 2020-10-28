package com.simon.learn.designpattern.decorator.general;

/**
 * @author simon.wei
 */
public abstract class Decorator extends Component {

    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }

}
