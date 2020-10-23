package com.huey.learning.springframework.aop.aspectj.declareparents;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableFlyAspect {

    @DeclareParents(value = "com.huey.learning.springframework.aop.aspectj.declareparents.Fish",
            defaultImpl = Bird.class)
    public Flyable flyer;

}