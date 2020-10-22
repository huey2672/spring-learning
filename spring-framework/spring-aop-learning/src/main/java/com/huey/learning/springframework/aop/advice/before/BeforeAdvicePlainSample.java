package com.huey.learning.springframework.aop.advice.before;

import com.huey.learning.springframework.aop.advice.HelloService;
import com.huey.learning.springframework.aop.advice.HelloServiceImpl;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author huey
 */
public class BeforeAdvicePlainSample {

    public static void main(String[] args) {

        HelloService targetService = new HelloServiceImpl();
        BeforeAdvice beforeAdvice = new LoggingBeforeAdvice();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(targetService);
        proxyFactory.addAdvice(beforeAdvice);

        HelloService proxy = (HelloService) proxyFactory.getProxy();
        proxy.sayHello("Huey");

    }

}
