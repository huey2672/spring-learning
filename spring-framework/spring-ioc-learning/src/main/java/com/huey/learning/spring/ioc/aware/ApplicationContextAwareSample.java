package com.huey.learning.spring.ioc.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class ApplicationContextAwareSample {

    public static void main(String[] args) {
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("application-context-aware/spring.xml");
    }

}
