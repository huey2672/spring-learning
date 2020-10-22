package com.huey.learning.springframework.aop.advice.after;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class LoggingAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.printf("%s#%s is finished at %s.\n",
                target.getClass().getSimpleName(), method.getName(), LocalDateTime.now());
    }

}