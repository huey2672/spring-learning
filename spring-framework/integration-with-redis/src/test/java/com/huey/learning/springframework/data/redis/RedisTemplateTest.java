package com.huey.learning.springframework.data.redis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author huey
 */
public class RedisTemplateTest {

    @Test
    public void testRedisTemplate() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);

        redisTemplate.opsForValue().set("foo", "bar");

        Object bar = redisTemplate.opsForValue().get("foo");
        System.out.println("Get bar from redis: " + bar);

    }

}
