package com.proxy.jdkdynamic;

import com.proxy.Greeting;
import com.proxy.GreetingImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lee on 16/2/22.
 */
public class JDKDynamicProxy implements InvocationHandler {
    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    public <T> T getProxy(){
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("after");
    }

    private void before() {
        System.out.println("before");
    }

    public static void main(String[] args) {
        JDKDynamicProxy proxy = new JDKDynamicProxy(new GreetingImpl());
        Greeting greeting=proxy.getProxy();
        greeting.sayHello("jack");
    }
}
