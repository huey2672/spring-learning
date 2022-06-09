package com.huey.learning.springframework.event.generic;

import lombok.Getter;

public class GenericSpringEvent<T> {

    @Getter
    private final T what;

    @Getter
    protected boolean success;

    public GenericSpringEvent(T what, boolean success) {
        this.what = what;
        this.success = success;
    }
}
