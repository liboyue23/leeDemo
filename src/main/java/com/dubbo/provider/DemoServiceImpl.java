package com.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by lee on 16/2/23.
 */
@Service
public class DemoServiceImpl implements DemoService{
    public String sayHello(String name) {
        return name+" sayHello";
    }
}
