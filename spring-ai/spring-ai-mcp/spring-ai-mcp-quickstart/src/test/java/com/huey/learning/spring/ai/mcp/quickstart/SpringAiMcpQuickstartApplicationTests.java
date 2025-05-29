package com.huey.learning.spring.ai.mcp.quickstart;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SpringAiMcpQuickstartApplicationTests {

    @Resource
    ChatClient.Builder chatClientBuilder;

    @Test
    public void testInformationRetrieval() {

    }


}
