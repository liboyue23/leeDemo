package com.proxy;

/**
 * Created by lee on 16/2/22.
 */
public class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println(name+" say hello");
    }
}
