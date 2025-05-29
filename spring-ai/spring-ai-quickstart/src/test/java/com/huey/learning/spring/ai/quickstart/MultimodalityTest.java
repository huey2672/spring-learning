package com.huey.learning.spring.ai.quickstart;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.MimeTypeUtils;

@Slf4j
@SpringBootTest
public class MultimodalityTest {

    @Resource
    ChatClient.Builder chatClientBuilder;


    @Test
    public void testMultimodality() {

        ChatClient chatClient = chatClientBuilder.build();

        String response = chatClient.prompt()
                .options(ChatOptions.builder().model("Qwen/Qwen2.5-VL-72B-Instruct").build())
                .user(u -> u.text("解释一下你在这张图片上看到了什么？")
                        .media(MimeTypeUtils.IMAGE_PNG, new ClassPathResource("/multimodal-test2.png")))
                .call()
                .content();

        log.info("response: {}", response);

    }

}
