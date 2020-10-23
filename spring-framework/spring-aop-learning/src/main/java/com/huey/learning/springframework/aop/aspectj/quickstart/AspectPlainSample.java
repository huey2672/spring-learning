package com.huey.learning.springframework.aop.aspectj.quickstart;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @author huey
 */
public class AspectPlainSample {

    public static void main(String[] args) {

        Waiter target = new Waiter();

        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(PreGreetingAspect.class);

        Waiter waiter = factory.getProxy();
        waiter.greetTo("Huey");
        waiter.serveTo("Huey");

    }

}
