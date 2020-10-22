package com.huey.learning.springframework.aop.advice.exception;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author huey
 */
public class LoggingExceptionAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception e) throws Throwable {
        System.out.printf("%s#%s throws an exception: %s.\n",
                target.getClass().getSimpleName(), method.getName(), e.getMessage());
    }

}
