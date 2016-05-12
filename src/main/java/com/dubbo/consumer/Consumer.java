package com.dubbo.consumer;

import com.dubbo.provider.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lee on 16/2/23.
 */
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");
        String hello = demoService.sayHello("world");
        System.out.println(hello);
    }
}
