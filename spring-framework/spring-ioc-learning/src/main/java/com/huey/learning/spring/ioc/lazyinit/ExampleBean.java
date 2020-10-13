package com.huey.learning.spring.ioc.lazyinit;

public class ExampleBean {

    public ExampleBean(String type) {
        System.out.println("In ExampleBean Constructor, Bean type is " + type + ".");
    }

}