package com.transaction;

/**
 * Created by lee on 16/2/2.
 */
public class Singleton {
    private static Singleton instance = null;

    private int a;

    private Singleton() {
        a = 1;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    System.out.println(Thread.currentThread().getName());
                    instance = new Singleton();
                    instance.setA(2);
                }
            }
        }
        return instance;
    }

}
