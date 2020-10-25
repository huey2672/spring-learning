package com.huey.learning.springframework.aop.aspectj.binding.args.annotation;

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

    @Before("@annotation(com.huey.learning.springframework.aop.aspectj.binding.args.annotation.Loggable) " +
            "&& @annotation(loggable)")
    public void log(JoinPoint joinPoint, Loggable loggable) {
        System.out.printf("%s(%s, %s) is invoked at %s\n",
                joinPoint.getSignature().toShortString(),
                loggable.serviceCode(),
                loggable.serviceDesc(),
                LocalDateTime.now());
    }

}
