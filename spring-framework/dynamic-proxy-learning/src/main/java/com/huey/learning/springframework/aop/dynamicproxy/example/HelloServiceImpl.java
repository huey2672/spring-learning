package com.huey.learning.springframework.aop.dynamicproxy.example;

import java.time.Duration;
import java.time.Instant;

/**
 * @author huey
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {

        long start = System.nanoTime();

        System.out.println("Hello, " + name + "!");

        long finish = System.nanoTime();
        System.out.printf("Executing %s finished in %s ns.\n", "sayHello", finish - start);

    }

    @Override
    public void sayGoodbye(String name) {

        long start = System.nanoTime();

        System.out.println("Goodbye, " + name + "!");

        long finish = System.nanoTime();
        System.out.printf("Executing %s finished in %s ns.\n", "sayGoodbye", finish - start);

    }

}
