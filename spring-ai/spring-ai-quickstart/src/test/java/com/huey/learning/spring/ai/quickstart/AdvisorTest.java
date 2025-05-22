package com.huey.learning.spring.ai.quickstart;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class AdvisorTest {



    @Resource
    ChatClient.Builder chatClientBuilder;

    @Test
    public void testSimpleLoggerAdvisor() {
        ChatClient chatClient = chatClientBuilder.defaultAdvisors(new SimpleLoggerAdvisor()).build();
        String answer = chatClient.prompt()
                .user("请介绍一下你自己")
                .call()
                .content();
        log.info(answer);
    }
}
