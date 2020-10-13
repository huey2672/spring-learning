package com.huey.learning.spring.ioc.namespace;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class CNamespaceSample {

    public static void main(String[] args) {

        AbstractApplicationContext appCtx = new ClassPathXmlApplicationContext("namespace/spring-c.xml");
        appCtx.start();

        GameCharacter magician = appCtx.getBean("magician", GameCharacter.class);
        System.out.println(magician);

        appCtx.stop();

    }

}
