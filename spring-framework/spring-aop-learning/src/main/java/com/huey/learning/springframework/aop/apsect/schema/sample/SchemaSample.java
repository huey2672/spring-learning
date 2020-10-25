package com.huey.learning.springframework.aop.apsect.schema.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class SchemaSample {

    public static void main(String[] args) {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("apsect/schema/sample/spring.xml");

        Waiter waiter = appCtx.getBean("waiter", Waiter.class);

        waiter.greetTo("Huey");
        waiter.serveTo("Huey");

    }

}
