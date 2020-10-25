package com.huey.learning.springframework.aop.aspectj.binding.args.annotation;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    @Loggable(serviceCode = "SC1001", serviceDesc = "Say hello to someone.")
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }

}