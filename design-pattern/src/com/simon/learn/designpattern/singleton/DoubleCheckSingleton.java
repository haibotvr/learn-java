package com.simon.learn.designpattern.singleton;

/**
 * 双重加锁
 *
 * @author simon.wei
 */
public class DoubleCheckSingleton {

    /**
     * 在java1.4及以前版本中，很多JVM对于volatile关键字的实现的问题，会导致“双重检查加锁”的失败，因此“双重检查加锁”机制只只能用在java5及以上的版本
     * 由于volatile关键字可能会屏蔽掉虚拟机中一些必要的代码优化，所以运行效率并不是很高。
     * 因此一般建议，没有特别的需要，不要使用。也就是说，虽然可以使用“双重检查加锁”机制来实现线程安全的单例，但并不建议大量采用，可以根据情况来选用
     */
    private volatile static DoubleCheckSingleton singleton = null;

    /**
     * 默认私有构造子
     */
    private DoubleCheckSingleton(){}

    public static DoubleCheckSingleton getSingleton() {
        //先检查实例是否存在，如果不存在才进入下面的同步块（检查是否要阻塞）
        if(singleton == null){
            /**
             * 当多个线程同时进入到这里时，进行排队等待，第一个线程首先创建了实例，然后返回结果。
             * 此时，第二个线程开始访问同步代码块，如果不检查对象是否为空，那么就会重复创建实例。
             */
            //同步块，线程安全的创建实例
            synchronized (DoubleCheckSingleton.class){
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if(singleton == null){
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }

}
