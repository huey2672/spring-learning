package com.huey.learning.springframework.aop.aspectj.quickstart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class AspectSample {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("aspectj/quickstart/spring.xml");

        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("Huey");
        waiter.serveTo("Huey");

    }

}
