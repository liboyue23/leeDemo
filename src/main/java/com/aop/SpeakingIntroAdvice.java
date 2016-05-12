package com.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * Created by lee on 16/2/22.
 */
@Component
public class SpeakingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology {
    public void saySorry(String name) {
        System.out.println("sorry "+name);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return super.invoke(invocation);
    }
}
