package com.huey.learning.springframework.cache.easysample;

import org.junit.Test;

public class UserServiceTest {

    @Test
    public void testGetUserById() {

        UserService userService = new UserService();

        String testUserId = "10001";
        User user1 = userService.getUserById(testUserId);
        System.out.println("user1: " + user1);

        User user2 = userService.getUserById(testUserId);
        System.out.println("user2: " + user2);

    }

}