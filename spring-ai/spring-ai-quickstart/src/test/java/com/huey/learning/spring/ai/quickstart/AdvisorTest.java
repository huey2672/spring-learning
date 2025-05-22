package com.huey.learning.spring.ai.quickstart;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@Slf4j
@SpringBootTest
public class AdvisorTest {



    @Resource
    ChatClient.Builder chatClientBuilder;

    @Test
    public void testSimpleLoggerAdvisor() {
        ChatClient chatClient = chatClientBuilder.defaultAdvisors(new SimpleLoggerAdvisor()).build();
        List<Book> recommendedBooks = chatClient.prompt()
                .user(u -> u.text("请推荐{num}本关于{genre}的经典书籍")
                        .param("num", "5")
                        .param("genre", "中国古代史"))
                .call()
                .entity(new ParameterizedTypeReference<>() {});
        log.info("推荐的书籍列表：{}", recommendedBooks);
    }

    @Test
    public void testMessageChatMemoryAdvisor() {
//        ChatClient chatClient = chatClientBuilder.defaultAdvisors(new MessageChatMemoryAdvisor()).build();
//        List<Book> recommendedBooks = chatClient.prompt()
//                .user(u -> u.text("请推荐{num}本关于{genre}的经典书籍")
//                        .param("num", "5")
//                        .param("genre", "中国古代史"))
//                .call()
//                .entity(new ParameterizedTypeReference<>() {});
    }

}
