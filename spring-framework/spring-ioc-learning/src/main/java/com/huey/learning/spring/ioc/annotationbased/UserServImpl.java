package com.huey.learning.spring.ioc.annotationbased;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userServ")
public class UserServImpl implements UserServ {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public User queryUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

}