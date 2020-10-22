package com.huey.learning.springframework.aop.advisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.printf("%s#%s, Hello, %s!\n",
                target.getClass().getSimpleName(), method.getName(), args[0]);
    }

}