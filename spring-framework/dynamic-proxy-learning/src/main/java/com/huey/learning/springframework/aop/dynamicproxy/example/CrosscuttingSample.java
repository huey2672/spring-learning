package com.huey.learning.springframework.aop.dynamicproxy.example;

/**
 * @author huey
 */
public class CrosscuttingSample {

    public static void main(String[] args) {

        HelloService helloService = new HelloServiceImpl();
        helloService.sayHello("Huey");
        helloService.sayGoodbye("Huey");

    }

}
