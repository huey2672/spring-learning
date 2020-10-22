package com.huey.learning.springframework.aop.advice;

import org.springframework.util.StringUtils;

public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {

        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("the parameter is empty.");
        }

        System.out.println("Hello, " + name + "!");

    }

}