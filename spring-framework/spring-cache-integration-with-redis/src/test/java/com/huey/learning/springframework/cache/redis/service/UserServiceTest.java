package com.huey.learning.springframework.cache.redis.service;

import com.huey.learning.springframework.cache.redis.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class UserServiceTest {

    @Test
    public void testGetUserById() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = ctx.getBean(UserService.class);

        String testUserId = "10001";
        User user1 = userService.getUserById(testUserId);
        System.out.println("user1: " + user1);

        User user2 = userService.getUserById(testUserId);
        System.out.println("user2: " + user2);

    }

    

}
