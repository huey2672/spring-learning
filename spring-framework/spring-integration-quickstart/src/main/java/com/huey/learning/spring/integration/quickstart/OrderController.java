package com.huey.learning.spring.integration.quickstart;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private MessageChannel orderInputChannel;

    @PostMapping("submit")
    public String submitOrder(@RequestBody Order order) {
        Message<Order> orderMessage = MessageBuilder.withPayload(order).build();
        orderInputChannel.send(orderMessage);
        return "OK";
    }

}
