package com.huey.learning.springframework.scheduling.sample.async.exceptionhandler;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * @author huey
 */
public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {

        System.out.println("Exception: " + ex.getClass().getSimpleName());
        System.out.println("Method: " + method.getName());
    }

}
