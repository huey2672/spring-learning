package com.huey.learning.springframework.aop.aspectj.pointcut.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huey
 */
public class AnnotationSample {

    public static void main(String[] args) {

        ApplicationContext appCtx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        HelloService helloService = appCtx.getBean(HelloService.class);

        helloService.sayHello("Huey");
        helloService.sayGoodbye("Huey");

    }

}
