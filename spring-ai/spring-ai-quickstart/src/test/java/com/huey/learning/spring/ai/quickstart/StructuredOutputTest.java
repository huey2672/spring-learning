package com.huey.learning.spring.ai.quickstart;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@Slf4j
@SpringBootTest
public class StructuredOutputTest {

    @Resource
    ChatClient.Builder chatClientBuilder;

    @Test
    public void testObjectStructuredOutput() {
        ChatClient chatClient = chatClientBuilder.build();
        Book recommendedBook = chatClient.prompt()
                .user(u -> u.text("请推荐一本关于{genre}的经典书籍")
                        .param("genre", "中国古代史"))
                .call()
                .entity(Book.class);
        log.info("推荐的书籍信息：{}", recommendedBook);
    }

    @Test
    public void testCollectionStructuredOutput() {
        ChatClient chatClient = chatClientBuilder.build();
        List<Book> recommendedBooks = chatClient.prompt()
                .user(u -> u.text("请推荐{num}本关于{genre}的经典书籍")
                        .param("num", "5")
                        .param("genre", "中国古代史"))
                .call()
                .entity(new ParameterizedTypeReference<>() {});
        log.info("推荐的书籍列表：{}", recommendedBooks);
    }

}
