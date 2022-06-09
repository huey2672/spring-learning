package com.huey.learning.springframework.event.custom;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class CustomSpringEvent extends ApplicationEvent {

    @Getter
    private final String message;

    public CustomSpringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

}