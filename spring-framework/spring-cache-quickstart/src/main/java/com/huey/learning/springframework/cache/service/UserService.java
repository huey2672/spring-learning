package com.huey.learning.springframework.cache.service;

import com.huey.learning.springframework.cache.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Cacheable(cacheNames = "user")
    public User getUserById(String userId) {
        System.out.println("query user: " + userId);
        return this.getUserFromDB(userId);
    }

    private User getUserFromDB(String userId) {
        System.out.println("query data from database: " + userId);
        return new User(userId);
    }

}