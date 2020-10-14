package com.huey.learning.spring.ioc.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class DependencyInjectionSample {

    public static void main(String[] args) {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("dependency-injection/spring.xml");

        Weapon bow = appCtx.getBean("bow", Weapon.class);
        System.out.println(bow);

    }

}
