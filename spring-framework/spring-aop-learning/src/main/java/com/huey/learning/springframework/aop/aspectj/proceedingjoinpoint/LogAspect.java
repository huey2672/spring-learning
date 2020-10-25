package com.huey.learning.springframework.aop.aspectj.proceedingjoinpoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    @Around("@annotation(com.huey.learning.springframework.aop.aspectj.pointcut.annotation.Loggable)")
    public void log(ProceedingJoinPoint joinPoint) throws Exception {

        System.out.printf("%s is invoked at %s.\n",
                joinPoint.getSignature().toShortString(), LocalDateTime.now());

        try {
            joinPoint.proceed();
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new Exception(throwable);
        }
        finally {
            System.out.printf("%s is finished at %s.\n",
                    joinPoint.getSignature().toShortString(), LocalDateTime.now());
        }

    }

}