package com.huey.learning.spring.ai.quickstart;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PromptTemplateTest {

    @Resource
    ChatClient.Builder chatClientBuilder;

    @Test
    public void testPromptTemplate() {
        ChatClient chatClient = chatClientBuilder.build();
        String answer = chatClient.prompt()
                .user(u -> u.text("请推荐一本关于{genre}的经典书籍")
                        .param("genre", "中国古代史"))

                .call()
                .content();
        log.info(answer);
    }

}
