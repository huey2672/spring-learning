package com.huey.learning.springframework.aop.aspectj.declareparents;

public class Fish extends Animal implements Swimable {

    public Fish() {
        this.name = "Fish";
    }

    @Override
    public void swim() {
        System.out.println(this.name + " is able to swim.");
    }

}