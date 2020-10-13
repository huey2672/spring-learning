package com.huey.learning.spring.ioc.di.collections;

import java.util.Properties;

/**
 * @author huey
 */
public class ComplexObjectOfProps {

    private Properties someProps;

    public Properties getSomeProps() {
        return someProps;
    }

    public void setSomeProps(Properties someProps) {
        this.someProps = someProps;
    }

    @Override
    public String toString() {
        return "ComplexObjectOfProps{" + "someProps=" + someProps + '}';
    }

}
