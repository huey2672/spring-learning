package com.huey.learning.spring.ioc.lazyinit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class LazyAnnotationSample {

    public static void main(String[] args) {

        System.out.println("Begin to initialize the application context.");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("lazy-init/spring-lazy-annotation.xml");
        System.out.println("The application context has been initialized.");

        System.out.println("Try to get lazyComponent.");
        appCtx.getBean(LazyComponent.class);


    }

}
