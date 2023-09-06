package com.huey.learning.springcloud.stream.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Slf4j
@SpringBootApplication
@EnableBinding(Sink.class)
public class ReceiverSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReceiverSampleApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void receive(String message) {
        log.info("Receive a message: {}", message);
    }

}
