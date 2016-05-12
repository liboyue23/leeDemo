package com.transaction;

import org.junit.Test;

/**
 * Created by lee on 16/2/2.
 */
public class TestSingleton {

    Singleton s1 = null;
    Singleton s2 = null;

    @Test
    public void test() {


        Thread t1 = new Thread(new Runnable() {
            public void run() {
                s1 = Singleton.getInstance();
                System.out.println(s1.getA() + "========s1");
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                s2 = Singleton.getInstance();
                System.out.println(s2.getA() + "========s2");
            }
        }, "t2");

        t1.start();
        t2.start();

    }
}
