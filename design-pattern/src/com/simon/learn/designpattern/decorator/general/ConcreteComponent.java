package com.simon.learn.designpattern.decorator.general;

/**
 * @author simon.wei
 */
public class ConcreteComponent extends Component {

    @Override
    public void operation() {
        System.out.println("具体的业务逻辑");
    }
}
