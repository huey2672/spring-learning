package com.huey.learning.springcloud.stream.quickstart;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SenderController {

    @Resource
    private Source source;

    @RequestMapping("send")
    public String send(String message) {
        source.output().send(MessageBuilder.withPayload(message).build());
        return "OK";
    }

}
