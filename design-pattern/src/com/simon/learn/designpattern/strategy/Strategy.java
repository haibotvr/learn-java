package com.simon.learn.designpattern.strategy;

/**
 * @author simon.wei
 */
public class Strategy {

    /**
     * 策略模式把对象本身和运算规则区分开来，因此我们整个模式也分为三个部分
     * 1、环境类(Context):用来操作策略的上下文环境，也就是我们游客
     * 2、抽象策略类(Strategy):策略的抽象，出行方式的抽象
     * 3、具体策略类(ConcreteStrategy):具体的策略实现，每一种出行方式的具体实现
     * 优点：
     * 1、我们之前在选择出行方式的时候，往往会使用if-else语句，也就是用户不选择A那么就选择B这样的一种情况。这种情况耦合性太高了，而且代码臃肿，有了策略模式我们就可以避免这种现象
     * 2、策略模式遵循开闭原则，实现代码的解耦合。扩展新的方法时也比较方便，只需要继承策略接口就好了
     * 缺点：
     * 1、客户端必须知道所有的策略类，并自行决定使用哪一个策略类
     * 2、策略模式会出现很多的策略类
     * 3、context在使用这些策略类的时候，这些策略类由于继承了策略接口，所以有些数据可能用不到，但是依然初始化了
     *
     */
}
