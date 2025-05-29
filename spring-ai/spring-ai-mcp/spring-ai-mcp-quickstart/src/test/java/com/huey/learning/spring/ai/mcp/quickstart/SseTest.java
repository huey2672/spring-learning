package com.huey.learning.spring.ai.mcp.quickstart;

import io.modelcontextprotocol.client.McpSyncClient;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
//@SpringBootTest
@SpringBootTest(properties = {
        "spring.profiles.active=sse"
})
public class SseTest {

    @Resource
    ChatClient.Builder chatClientBuilder;

    @Resource
    private List<McpSyncClient> mcpSyncClients;

    @Test
    public void testSse() {
        String result = chatClientBuilder.build()
                .prompt()
                .toolCallbacks(new SyncMcpToolCallbackProvider(mcpSyncClients))
                .user("福州有几个火车站")
                .call()
                .content();
        log.info("result: {}", result);
    }

    @Test
    public void testWithoutMcp() {
        String result = chatClientBuilder.build()
                .prompt()
                .user("福州有几个火车站")
                .call()
                .content();
        log.info("result: {}", result);
    }

}
