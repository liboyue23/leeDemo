package com.proxy.cglib;

import com.proxy.Greeting;
import com.proxy.GreetingImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lee on 16/2/22.
 */
public class CGLibDynamicProxy implements MethodInterceptor {

    private CGLibDynamicProxy(){

    }

    static class ProxyHolder{
        private static CGLibDynamicProxy instance=new CGLibDynamicProxy();
    }

    public static CGLibDynamicProxy getInstance(){
        return ProxyHolder.instance;
    }

    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls,this);
    }

    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result=methodProxy.invokeSuper(target,args);
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
        Greeting greeting=CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        greeting.sayHello("jack");
    }
}
