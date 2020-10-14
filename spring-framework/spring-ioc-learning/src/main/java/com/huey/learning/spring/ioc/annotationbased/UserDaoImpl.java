package com.huey.learning.spring.ioc.annotationbased;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    List<User> users = new ArrayList<>();

    public UserDaoImpl() {
        users.add(new User(1001L, "huey", "123"));
        users.add(new User(1002L, "tmac", "abc"));
        users.add(new User(1003L, "suer", "xxx"));
    }

    @Override
    public User getUserByUsername(String username) {

        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findAny()
                .orElse(null);

    }

}