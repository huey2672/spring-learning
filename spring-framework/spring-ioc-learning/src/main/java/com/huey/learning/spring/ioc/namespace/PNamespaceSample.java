package com.huey.learning.spring.ioc.namespace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class PNamespaceSample {

    public static void main(String[] args) {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("namespace/spring-p.xml");

        GameCharacter magician = appCtx.getBean("magician", GameCharacter.class);
        System.out.println(magician);

    }

}
