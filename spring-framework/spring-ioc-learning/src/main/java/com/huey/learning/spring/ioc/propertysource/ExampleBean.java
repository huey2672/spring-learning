package com.huey.learning.spring.ioc.propertysource;

/**
 * @author huey
 */
public class ExampleBean {

    private Object someField;

    public ExampleBean(Object someField) {
        this.someField = someField;
    }

    @Override
    public String toString() {
        return "ExampleBean{" + "someField=" + someField + '}';
    }

}
