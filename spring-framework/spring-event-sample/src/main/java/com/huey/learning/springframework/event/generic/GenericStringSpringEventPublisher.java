package com.huey.learning.springframework.event.generic;

import com.huey.learning.springframework.event.custom.CustomSpringEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class GenericStringSpringEventPublisher {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishGenericEvent(final String message) {
        GenericStringSpringEvent genericSpringEvent = new GenericStringSpringEvent(message, true);
        log.info("Publishing generic event: {}", genericSpringEvent);
        applicationEventPublisher.publishEvent(genericSpringEvent);
    }

}