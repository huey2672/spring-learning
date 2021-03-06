package com.huey.learning.spring.ioc.lazyinit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class LazyInitSample {

    public static void main(String[] args) {

        System.out.println("Begin to initialize the application context.");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("lazy-init/spring.xml");
        System.out.println("The application context has been initialized.");

        System.out.println("Try to get lazyInitBean.");
        ExampleBean lazyInitBean = appCtx.getBean("lazyInitBean", ExampleBean.class);

        System.out.println("Try to get preInitBean.");
        ExampleBean preInitBean = appCtx.getBean("preInitBean", ExampleBean.class);

    }

}
