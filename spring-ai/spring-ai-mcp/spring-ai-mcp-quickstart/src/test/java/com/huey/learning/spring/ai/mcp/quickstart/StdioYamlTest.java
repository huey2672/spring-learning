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
@SpringBootTest(properties = {
        "spring.profiles.active=yaml"
})
public class StdioYamlTest {

    @Resource
    ChatClient.Builder chatClientBuilder;

    @Resource
    private List<McpSyncClient> mcpSyncClients;

    @Test
    public void testStdio() {
        String result = chatClientBuilder.build()
                .prompt()
                .toolCallbacks(new SyncMcpToolCallbackProvider(mcpSyncClients))
                .user("请把 test.txt 文件的内容翻译成中文，并把翻译后的内容写到 test-zh.txt 文件中，如果 test-zh.txt 不存在则创建一份新的文件，如果存在则覆盖原来的内容")
                .call()
                .content();
        log.info("result: {}", result);

    }


}
