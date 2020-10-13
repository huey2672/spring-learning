package com.huey.learning.spring.ioc.namespace;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class PNamespaceSample {

    public static void main(String[] args) {

        AbstractApplicationContext appCtx = new ClassPathXmlApplicationContext("namespace/spring-p.xml");

        GameCharacter magician = appCtx.getBean("magician", GameCharacter.class);
        System.out.println(magician);

    }

}
