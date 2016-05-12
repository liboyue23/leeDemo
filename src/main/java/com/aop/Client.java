package com.aop;

import com.proxy.Greeting;
import com.proxy.GreetingImpl;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lee on 16/2/22.
 */
public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingAfterAdvice());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());

        Greeting greeting= (Greeting) proxyFactory.getProxy();
        greeting.sayHello("jack");
    }

    @Test
    public void testAround(){
        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingAroudAdvice());

        Greeting greeting= (Greeting) proxyFactory.getProxy();
        greeting.sayHello("mike");
    }

    @Test
    public void testAround2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Speaking speaking= (Speaking) context.getBean("speakingProxy");
        speaking.say("jack");
    }

    @Test
    public void testAround3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        SpeakingImpl speaking= (SpeakingImpl) context.getBean("speakingProxy");
        speaking.say("jack");

        Apology apology= (Apology) speaking;
        apology.saySorry("jack");
    }
}
