package com.simon.learn.thread;

/**
 * @author simon.wei
 */
public class ThreadJoin {

    public static void main(String[] args) {

        CustomThread t1 = new CustomThread("a");
        CustomThread t2 = new CustomThread("b");

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

}

class CustomThread extends Thread {

    private String name;

    public CustomThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.name);

    }
}
