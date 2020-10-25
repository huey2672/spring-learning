package com.huey.learning.springframework.aop.apsect.schema.sample;

public class PreGreetingAspect {

    public void beforeGreeting() {
        System.out.println("Nice to meet you.");
    }

}