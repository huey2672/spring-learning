package com.huey.learning.springframework.cache.redis.service;

import com.huey.learning.springframework.cache.redis.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Cacheable(cacheNames = "user")
    public User getUserById(String userId) {
        System.out.println("query user: " + userId);
        return new User(userId);
    }

}