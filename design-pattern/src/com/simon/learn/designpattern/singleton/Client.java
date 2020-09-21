package com.simon.learn.designpattern.singleton;


/**
 * @author simon.wei
 */
public class Client {

    public static void main(String[] args) {
        Thread t1 = new Thread(new CustomThread());
        Thread t2 = new Thread(new CustomThread());
        t1.start();
        t2.start();
    }
}

class CustomThread implements Runnable {
    @Override
    public void run() {
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + "====" + instance);
    }
}
