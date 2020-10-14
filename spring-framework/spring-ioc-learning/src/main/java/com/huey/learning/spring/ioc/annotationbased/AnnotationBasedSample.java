package com.huey.learning.spring.ioc.annotationbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class AnnotationBasedSample {

    public static void main(String[] args) {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("annotation-based/spring.xml");

        UserServ userServ = appCtx.getBean("userServ", UserServ.class);

        String username = "huey";
        User user = userServ.queryUserByUsername(username);
        System.out.println(user);

    }

}
