package com.huey.learning.springframework.aop.advice.introduction;

import com.huey.learning.springframework.aop.advice.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class IntroductionInterceptorSample {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("advice/introduction/spring.xml");
        HelloService helloService = (HelloService) ctx.getBean("helloService");
        helloService.sayHello("Huey");

        ((Loggable) helloService).setLoggerActive(true);
        helloService.sayHello("Huey");

    }

}
