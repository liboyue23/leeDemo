package com.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by lee on 16/2/22.
 */
public class GreetingBeforeAndAfterAdvice implements MethodBeforeAdvice,AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("after");
    }

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before");
    }
}
