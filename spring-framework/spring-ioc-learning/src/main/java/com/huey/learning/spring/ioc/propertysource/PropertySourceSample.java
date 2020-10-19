package com.huey.learning.spring.ioc.propertysource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huey
 */
public class PropertySourceSample {

    public static void main(String[] args) {

        ApplicationContext appCtx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        ExampleBean exampleBean = appCtx.getBean(ExampleBean.class);
        System.out.println(exampleBean);


        String appExampleVal = appCtx.getEnvironment().getProperty("app.example.val");
        System.out.println("${app.example.val} = " + appExampleVal);

    }

}
