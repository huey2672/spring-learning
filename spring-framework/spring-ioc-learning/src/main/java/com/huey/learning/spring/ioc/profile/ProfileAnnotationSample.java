package com.huey.learning.spring.ioc.profile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author huey
 */
public class ProfileAnnotationSample {

    public static void main(String[] args) {

        ApplicationContext appCtx = new AnnotationConfigApplicationContext(DevelopmentConfiguration.class, ProductionConfiguration.class);
        ExampleBean exampleBean = appCtx.getBean(ExampleBean.class);
        System.out.println(exampleBean);

        ((ConfigurableEnvironment) appCtx.getEnvironment()).setActiveProfiles("development");

    }

}
