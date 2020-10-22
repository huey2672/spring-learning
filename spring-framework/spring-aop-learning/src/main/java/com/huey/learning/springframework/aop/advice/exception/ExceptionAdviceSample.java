package com.huey.learning.springframework.aop.advice.exception;

import com.huey.learning.springframework.aop.advice.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class ExceptionAdviceSample {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("advice/exception/spring.xml");
        HelloService helloService = (HelloService) ctx.getBean("helloService");

        helloService.sayHello("Huey");
        helloService.sayHello(null);

    }

}
