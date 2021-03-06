package com.huey.learning.springframework.aop.aspectj.pointcut.compound;

import com.huey.learning.springframework.aop.aspectj.pointcut.annotation.HelloService;
import com.huey.learning.springframework.aop.aspectj.pointcut.annotation.Loggable;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    @Loggable
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    @Override
    public void sayGoodbye(String name) {
        System.out.println("Goodbye, " + name + "!");
    }

}