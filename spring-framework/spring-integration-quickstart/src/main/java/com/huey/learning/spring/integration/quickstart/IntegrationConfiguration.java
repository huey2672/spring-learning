package com.huey.learning.spring.integration.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

/**
 * @author huey
 */
@Slf4j
@Configuration
public class IntegrationConfiguration {

    @Bean
    public MessageChannel orderInputChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "orderInputChannel")
    public MessageHandler orderMessageHandler() {
        return message -> {
            Object payload = message.getPayload();
            if (!(payload instanceof Order)) {
                throw new IllegalArgumentException("message's payload must be an instance of Order");
            }

            Order order = (Order) payload;
            log.info("Receive an order: {}", order);
            // do something with the order...
        };
    }

}