package com.huey.learning.springframework.aop.aspectj.pointcut.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author huey
 */
@Aspect
@Component
public class LogAspect {

    @Before("@annotation(com.huey.learning.springframework.aop.aspectj.pointcut.annotation.Loggable)")
    public void log(JoinPoint joinPoint) {
        System.out.printf("%s is invoked at %s\n",
                joinPoint.getSignature().toShortString(), LocalDateTime.now());
    }

}
