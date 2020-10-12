package com.huey.learning.spring.ioc.di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class DependencyInjectionSample {

    public static void main(String[] args) {

        AbstractApplicationContext appCtx = new ClassPathXmlApplicationContext("dependency-injection/spring.xml");
        appCtx.start();

        Weapon bow = appCtx.getBean("bow", Weapon.class);
        System.out.println(bow);

        appCtx.stop();

    }

}
