package com.huey.learning.springframework.aop.advice.around;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.time.LocalDateTime;

public class LoggingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        String serviceName = invocation.getClass().getSimpleName();
        String methodName = invocation.getMethod().getName();

        System.out.printf("%s#%s is invoked at %s.\n", serviceName, methodName, LocalDateTime.now());

        Object returnValue = invocation.proceed();

        System.out.printf("%s#%s is finished at %s.\n", serviceName, methodName, LocalDateTime.now());

        return returnValue;

    }

}