package com.huey.learning.springframework.aop.apsect.schema.advice.around;

import org.aspectj.lang.ProceedingJoinPoint;

public class GreetingAspect {

    public void aroundGreeting(ProceedingJoinPoint joinPoint) throws Throwable {

        // before invoking...

        joinPoint.proceed();

        // after invoking...

    }

}