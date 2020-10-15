package com.huey.learning.spring.ioc.lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author huey
 */
@Component
public class ExampleThree {

    private Object someFiled;

    public Object getSomeFiled() {
        return someFiled;
    }

    public void setSomeFiled(Object someFiled) {
        this.someFiled = someFiled;
    }

    @PostConstruct
    public void init() {
        System.out.println("ExampleThree(someFiled = " + someFiled + ") has been initiated.");
    }

}
