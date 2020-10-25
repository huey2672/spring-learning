package com.huey.learning.springframework.aop.apsect.schema.advice.declareparents;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class DeclareParentsSample {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("apsect/schema/advice/declare-parents/spring.xml");

        Fish fish = ctx.getBean("fish", Fish.class);
        fish.swim();

        ((Flyable) fish).fly();

    }

}
