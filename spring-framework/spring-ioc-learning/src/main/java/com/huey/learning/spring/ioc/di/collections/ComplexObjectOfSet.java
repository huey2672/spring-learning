package com.huey.learning.spring.ioc.di.collections;

import java.util.Set;

/**
 * @author huey
 */
public class ComplexObjectOfSet {

    private Set someSet;

    public Set getSomeSet() {
        return someSet;
    }

    public void setSomeSet(Set someSet) {
        this.someSet = someSet;
    }

    @Override
    public String toString() {
        return "ComplexObjectOfSet{" + "someSet=" + someSet + '}';
    }

}
