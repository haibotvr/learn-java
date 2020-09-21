package com.simon.learn.designpattern.singleton;

/**
 * @author simon.wei
 */
public class LazyHolderClassSingleton {

    /**
     * 1、什么是类级内部类
     *   简单点说，类级内部类指的是，有static修饰的成员式内部类。如果没有static修饰的成员式内部类被称为对象级内部类。
     *   类级内部类相当于其外部类的static成分，它的对象与外部类对象间不存在依赖关系，因此可直接创建。
     *   象级内部类的实例，是绑定在外部对象实例中的。
     *   类级内部类中，可以定义静态的方法。在静态方法中只能够引用外部类中的静态成员方法或者成员变量。
     *   类级内部类相当于其外部类的成员，只有在第一次被使用的时候才被会装载。
     *
     * 2、多线程缺省同步锁的知识
     *   大家都知道，在多线程开发中，为了解决并发问题，主要是通过使用synchronized来加互斥锁进行同步控制。
     *   但是在某些情况中，JVM已经隐含地为您执行了同步，这些情况下就不用自己再来进行同步控制了。这些情况包括：
     *   1）由静态初始化器（在静态字段上或static{}块中的初始化器）初始化数据时
     *   2）访问final字段时
     *   3）在创建线程之前创建对象时
     *   4）线程可以看见它将要处理的对象时
     */

    private LazyHolderClassSingleton(){
        //防止被反射破坏
        if(SingletonHolder.instance != null) {
            throw new RuntimeException("不允许非法访问");
        }
    }

    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
     */
    private static class SingletonHolder{

        /**
         * 在这个类级内部类里面去创建对象实例。这样一来，只要不使用到这个类级内部类，那就不会创建对象实例，从而同时实现延迟加载和线程安全。
         * 静态初始化器，由JVM来保证线程安全
         */
        private static LazyHolderClassSingleton instance = new LazyHolderClassSingleton();

    }

    public static LazyHolderClassSingleton getInstance(){
        return SingletonHolder.instance;
    }

}
