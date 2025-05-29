package com.huey.learning.spring.ai;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SpringAiMcpSseClientApplicationTests {

    @Resource
    ChatClient.Builder chatClientBuilder;

    @Test
    public void testMcpSseClient2() {

        HttpClientSseClientTransport transport = HttpClientSseClientTransport
                .builder("http://localhost:8080")
                .sseEndpoint("/sse")
                .build();
        try (McpSyncClient mcpSyncClient = McpClient.sync(transport).build()) {
            mcpSyncClient.initialize();
            String response = chatClientBuilder.build()
                    .prompt("ID 为 1001 的客户是谁？")
                    .toolCallbacks(new SyncMcpToolCallbackProvider(mcpSyncClient))
                    .call()
                    .content();
            log.info("response: {}", response);
        }

    }

    @Test
    public void test12306McpSseClient() {

        ChatClient chatClient = chatClientBuilder.build();
        HttpClientSseClientTransport transport = HttpClientSseClientTransport.builder("https://mcp.api-inference.modelscope.cn").sseEndpoint("/326f935dff5e41/sse").build();
        try (McpSyncClient mcpSyncClient = McpClient.sync(transport).build()) {
            mcpSyncClient.initialize();
            String response = chatClient.prompt("福州有几个火车站？")
                    .toolCallbacks(new SyncMcpToolCallbackProvider(mcpSyncClient))
                    .call()
                    .content();
            log.info("response: {}", response);
        }

        // https://mcp.api-inference.modelscope.cn/326f935dff5e41/sse
    }

}
