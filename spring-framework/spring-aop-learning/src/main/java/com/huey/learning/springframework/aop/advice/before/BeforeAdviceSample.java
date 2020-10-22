package com.huey.learning.springframework.aop.advice.before;

import com.huey.learning.springframework.aop.advice.HelloService;
import com.huey.learning.springframework.aop.advice.HelloServiceImpl;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class BeforeAdviceSample {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("advice/before/spring.xml");
        HelloService helloService = (HelloService) ctx.getBean("helloService");
        helloService.sayHello("Huey");

    }

}
