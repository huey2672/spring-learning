package com.huey.learning.spring.ioc.lifecycle;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author huey
 */
public class ExampleOne implements InitializingBean {

    private Object someFiled;

    public Object getSomeFiled() {
        return someFiled;
    }

    public void setSomeFiled(Object someFiled) {
        this.someFiled = someFiled;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("All properties of ExampleOne(someFiled = " + someFiled + ") were set.");
    }

}
