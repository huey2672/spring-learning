package com.huey.learning.springcloud.gateway.gateway.predicate;

import org.springframework.stereotype.Service;

@Service
public class VipService {

    public boolean isVip(String userId) {
        return "huey".equals(userId);
    }

}
