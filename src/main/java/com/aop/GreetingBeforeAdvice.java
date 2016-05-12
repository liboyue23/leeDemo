package com.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by lee on 16/2/22.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice{
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before");
    }
}
