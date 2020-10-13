package com.huey.learning.spring.ioc.di.collections;

import java.util.List;

/**
 * @author huey
 */
public class ComplexObjectOfList {

    private List someList;

    public List getSomeList() {
        return someList;
    }

    public void setSomeList(List someList) {
        this.someList = someList;
    }

    @Override
    public String toString() {
        return "ComplexObjectOfList{" + "someList=" + someList + '}';
    }

}
