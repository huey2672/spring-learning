package com.huey.learning.spring.ioc.lifecycle;

/**
 * @author huey
 */
public class ExampleTwo {

    private Object someFiled;

    public Object getSomeFiled() {
        return someFiled;
    }

    public void setSomeFiled(Object someFiled) {
        this.someFiled = someFiled;
    }

    public void init() {
        System.out.println("ExampleTwo(someFiled = " + someFiled + ") has been initiated.");
    }

}
