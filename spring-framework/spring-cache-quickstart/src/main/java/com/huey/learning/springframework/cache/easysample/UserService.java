package com.huey.learning.springframework.cache.easysample;

public class UserService {

    private CacheManager<User> cacheManager;

    public UserService() {
        cacheManager = new CacheManager<>();
    }

    public User getUserById(String userId) {

        /*
         * 先在缓存中查询，如果在缓存中，则直接返回
         */
        User user = cacheManager.getValue(userId);
        if (user != null) {
            System.out.println("get data from cache: " + userId);
            return user;
        }

        /*
         * 否则再从数据库中查询，如果查询到数据，则更新到缓存中。
         */
        user = this.getUserFromDB(userId);
        if (user != null) {
            cacheManager.setValue(userId, user);
        }

        return user;

    }

    private User getUserFromDB(String userId) {
        System.out.println("query data from database: " + userId);
        return new User(userId);
    }

}