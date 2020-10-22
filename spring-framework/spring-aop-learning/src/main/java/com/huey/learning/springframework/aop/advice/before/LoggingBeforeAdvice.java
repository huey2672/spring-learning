package com.huey.learning.springframework.aop.advice.before;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class LoggingBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.printf("%s#%s is invoked at %s.\n",
                target.getClass().getSimpleName(), method.getName(), LocalDateTime.now());
    }

}