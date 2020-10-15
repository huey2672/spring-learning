package com.huey.learning.spring.ioc.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class LifeCycleSample {

    public static void main(String[] args) {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("lifecycle/spring.xml");

        appCtx.getBean(ExampleOne.class);
        appCtx.getBean(ExampleTwo.class);
        appCtx.getBean(ExampleThree.class);

    }

}
