package com.huey.learning.springframework.aop.aspectj.declareparents;

public class Bird extends Animal implements Flyable {

    public Bird() {
        this.name = "Bird";
    }

    @Override
    public void fly() {
        System.out.println(this.name + " is able to fly.");
    }

}