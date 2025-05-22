package com.huey.learning.spring.ai.quickstart;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AbstractMessage;
import org.springframework.ai.chat.metadata.ChatResponseMetadata;
import org.springframework.ai.chat.metadata.PromptMetadata;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Slf4j
@SpringBootTest
public class ChatResponseTest {

    @Resource
    ChatClient.Builder chatClientBuilder;

    @Test
    public void testChatResponse() {
        ChatClient chatClient = chatClientBuilder.build();

        ChatResponse chatResponse = chatClient.prompt()
                .user("请介绍一下你自己")
                .call()
                .chatResponse();

        Optional.of(chatResponse)
                .map(ChatResponse::getMetadata)
                .map(ChatResponseMetadata::getUsage)
                .ifPresent(usage -> {
                    log.info("promptTokens: {}", usage.getPromptTokens());
                    log.info("completionTokens: {}", usage.getCompletionTokens());
                    log.info("totalTokens: {}", usage.getTotalTokens());
                });

        Optional.of(chatResponse)
                .map(ChatResponse::getResult)
                .map(Generation::getOutput)
                .map(AbstractMessage::getText)
                .ifPresent(log::info);
    }

}
