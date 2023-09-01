package com.huey.learning.spring.integration.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Slf4j
public class OrderMessageHandler implements MessageHandler {

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {

        Object payload = message.getPayload();
        if (!(payload instanceof Order)) {
            throw new IllegalArgumentException("message's payload must be an instance of Order");
        }

        Order order = (Order) payload;
        log.info("Receive an order: {}", order);
        // do something with the order...

    }

}
