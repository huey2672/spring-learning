package com.huey.learning.spring.ioc.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huey
 */
public class JavaBasedSample {

    public static void main(String[] args) {

        ApplicationContext appCtx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        HelloComponent helloComponent = appCtx.getBean(HelloComponent.class);

        helloComponent.sayHello("Huey");

    }

}
