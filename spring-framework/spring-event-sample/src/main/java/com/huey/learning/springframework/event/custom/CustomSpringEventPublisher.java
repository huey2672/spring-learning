package com.huey.learning.springframework.event.custom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class CustomSpringEventPublisher {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(final String message) {
        CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        log.info("Publishing custom event: {}", customSpringEvent);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }

}