package com.huey.learning.spring.ioc.javabased;

import org.springframework.stereotype.Component;

/**
 * @author huey
 */
@Component
public class HelloComponent {

    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }

}
