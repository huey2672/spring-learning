package com.huey.learning.springframework.aop.pointcut.compound;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.time.LocalDateTime;

@Aspect
public class LogAspect {

    @Before("within(com.huey.learning..*) && execution(* sayHello(..))")
    public void log(JoinPoint joinPoint) {
        System.out.printf("%s is invoked at %s\n",
                joinPoint.getSignature().toShortString(), LocalDateTime.now());
    }

}