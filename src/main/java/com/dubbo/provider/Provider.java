package com.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by lee on 16/2/23.
 */
public class Provider {
    public static void main(String[] args) throws IOException {
//        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("dubbo-provider.xml");
//        context.start();
//
//        System.in.read();
//

        com.alibaba.dubbo.container.Main.main(args);
    }
}
