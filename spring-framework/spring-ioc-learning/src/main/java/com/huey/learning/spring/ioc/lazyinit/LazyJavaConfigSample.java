package com.huey.learning.spring.ioc.lazyinit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huey
 */
public class LazyJavaConfigSample {

    public static void main(String[] args) {

        System.out.println("Begin to initialize the application context.");
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        System.out.println("The application context has been initialized.");

        System.out.println("Try to get lazyBean.");
        appCtx.getBean(ExampleBean.class);

    }

}
