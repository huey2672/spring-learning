package com.huey.learning.spring.ioc.di.collections;

import java.util.Map;

/**
 * @author huey
 */
public class ComplexObjectOfMap {

    private Map someMap;

    public Map getSomeMap() {
        return someMap;
    }

    public void setSomeMap(Map someMap) {
        this.someMap = someMap;
    }

    @Override
    public String toString() {
        return "ComplexObjectOfMap{" + "someMap=" + someMap + '}';
    }

}
