package com.huey.learning.springframework.event.annotationbased;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnnotationDrivenEventListener {

    @EventListener
    public void handleContextRefreshed(ContextRefreshedEvent cse) {
        log.info("Handling context refreshed event.");
    }

}