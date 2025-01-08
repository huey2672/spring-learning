package com.huey.learning.spring.ai.quickstart;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Resource
    private ChatModel chatModel;

    @RequestMapping("/chat")
    public Object chat(String message) {
        return chatModel.call(message);
    }

}