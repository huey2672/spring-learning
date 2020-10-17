package com.huey.learning.spring.ioc.profile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author huey
 */
public class ProfileAnnotationSample {

    public static void main(String[] args) {

        ApplicationContext appCtx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        ExampleBean exampleBean = appCtx.getBean(ExampleBean.class);
        System.out.println(exampleBean);

    }

}
