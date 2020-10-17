package com.huey.learning.spring.ioc.importannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huey
 */
public class ImportAnnotationSample {

    public static void main(String[] args) {
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        HelloService helloService = appCtx.getBean(HelloService.class);
        helloService.sayHello("Huey");
    }

}
