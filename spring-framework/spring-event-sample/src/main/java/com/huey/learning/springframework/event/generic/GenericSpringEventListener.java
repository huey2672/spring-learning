package com.huey.learning.springframework.event.generic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GenericSpringEventListener {

    @EventListener(condition = "#event.success")
    public void handleSuccessful(GenericSpringEvent<String> event) {
        log.info("Handling generic event (conditional): {}", event.getWhat());
    }

}