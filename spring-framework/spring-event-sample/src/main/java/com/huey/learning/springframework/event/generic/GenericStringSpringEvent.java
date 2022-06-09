package com.huey.learning.springframework.event.generic;

public class GenericStringSpringEvent extends GenericSpringEvent<String> {

    public GenericStringSpringEvent(String what, boolean success) {
        super(what, success);
    }

}
