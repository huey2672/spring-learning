package com.huey.learning.spring.ioc.namespace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class CNamespaceSample {

    public static void main(String[] args) {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("namespace/spring-c.xml");

        GameCharacter magician = appCtx.getBean("magician", GameCharacter.class);
        System.out.println(magician);

    }

}
