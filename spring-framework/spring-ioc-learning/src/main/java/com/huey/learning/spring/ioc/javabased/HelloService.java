package com.huey.learning.spring.ioc.javabased;

/**
 * @author huey
 */
public class HelloService {

    private HelloComponent helloComponent;

    public HelloService(HelloComponent helloComponent) {
        this.helloComponent = helloComponent;
    }

    public void sayHello(String name) {
        helloComponent.sayHello(name);
    }

}
