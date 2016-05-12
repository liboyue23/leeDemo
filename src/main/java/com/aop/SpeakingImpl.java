package com.aop;

import org.springframework.stereotype.Component;

/**
 * Created by lee on 16/2/22.
 */
@Component
public class SpeakingImpl implements Speaking {
    public void say(String name) {
        System.out.println(name+" 在说话");
    }
}
