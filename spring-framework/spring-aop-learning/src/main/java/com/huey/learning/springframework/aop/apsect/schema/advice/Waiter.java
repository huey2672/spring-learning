package com.huey.learning.springframework.aop.apsect.schema.advice;

public class Waiter {

    public void greetTo(String name) {
        System.out.println("The waiter greets to " + name + ".");
    }

    public void serveTo(String name) {
        System.out.println("The waiter serves to " + name + ".");
    }

}
