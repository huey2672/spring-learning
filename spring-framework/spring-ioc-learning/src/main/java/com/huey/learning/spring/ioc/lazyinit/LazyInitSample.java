package com.huey.learning.spring.ioc.lazyinit;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class LazyInitSample {

    public static void main(String[] args) {

        System.out.println("Begin to initialize the application context.");
        AbstractApplicationContext appCtx = new ClassPathXmlApplicationContext("lazy-init/spring.xml");
        appCtx.start();
        System.out.println("The application context has been initialized.");

        ExampleBean eb1 = appCtx.getBean("eb1", ExampleBean.class);
        ExampleBean eb2 = appCtx.getBean("eb2", ExampleBean.class);

        appCtx.stop();

    }

}
