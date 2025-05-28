package com.huey.learning.spring.ai.toolcalling;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ToolContext;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.definition.ToolDefinition;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.ai.tool.method.MethodToolCallback;
import org.springframework.ai.tool.support.ToolDefinitions;
import org.springframework.ai.util.json.schema.JsonSchemaGenerator;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@SpringBootTest
class SpringAiToolCallingApplicationTests {

    @Resource
    ChatClient.Builder chatClientBuilder;

    @Test
    public void testInformationRetrieval() {
        ChatClient chatClient = chatClientBuilder.build();
        String response = chatClient.prompt("北京时间现在是几号？")
                .tools(new DateTimeTools())
                .call()
                .content();
        log.info("response: {}", response);
    }


    @Test
    public void testInformationRetrievalWithoutTool() {
        ChatClient chatClient = chatClientBuilder.build();
        String response = chatClient.prompt("北京时间现在是几号？")
                .call()
                .content();
        log.info("response: {}", response);
    }


    @Test
    public void testTakingActions() {
        ChatClient chatClient = chatClientBuilder.build();
        String response = chatClient.prompt("请设置一个十分钟后的闹钟")
                .tools(new DateTimeTools())
                .call()
                .content();
        log.info("response: {}", response);
    }

    @Test
    public void testToolCallback() {
        ChatClient chatClient = chatClientBuilder.build();
        ToolCallback[] dateTimeTools = ToolCallbacks.from(new DateTimeTools());
        String s = dateTimeTools[0].getToolDefinition().inputSchema();
        System.out.println("s = " + s);
        String response = chatClient.prompt("北京时间现在是几号？")
                .toolCallbacks(dateTimeTools)
                .call()
                .content();
        log.info("response: {}", response);
    }

    @Test
    public void testMethodToolCallback() {

        // 使用反射定位要设置成工具的方法
        Method method = ReflectionUtils.findMethod(DateTimeTools.class, "getCurrentDateTime");
        // 设置工具的规格属性
        ToolDefinition toolDefinition =  ToolDefinitions.builder(method).description("获取用户所在时区中的当前日期和时间").build();
        // 使用 MethodToolCallback.Builder 构建 MethodToolCallback
        ToolCallback dateTimeTools = MethodToolCallback.builder()
                .toolDefinition(toolDefinition)
                .toolMethod(method)
                // 如果方法是静态地，可以省略 toolObject 方法
                .toolObject(new DateTimeTools())
                .build();
        ChatClient chatClient = chatClientBuilder.build();
        String response = chatClient.prompt("北京时间现在是几号？")
                .toolCallbacks(dateTimeTools)
                .call()
                .content();
        log.info("response: {}", response);
    }

    @Test
    public void testFunctionToolCallback() {


        ToolCallback toolCallback = FunctionToolCallback.builder("getCurrentDateTime",
                        () -> LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString()
                )
                .description("获取用户所在时区中的当前日期和时间")
                .build();

    }
    @Test
    public void testToolContext() {
        ChatClient chatClient = chatClientBuilder.build();
        String response = chatClient.prompt("ID 为 1001 的客户是谁？")
                .toolContext(Map.of("tenantId", "han"))
                .tools(new CustomerTools())
                .call()
                .content();
        log.info("response: {}", response);
    }

    @Test
    public void testReturnDirect() {
        ChatClient chatClient = chatClientBuilder.build();
        Customer response = chatClient.prompt("ID 为 1001 的客户是谁？")
                .toolContext(Map.of("tenantId", "han"))
                .tools(new CustomerTools())
                .call()
                .entity(Customer.class);
        log.info("Customer: {}", response);
    }


}
