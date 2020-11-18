package com.huey.learning.spring.session.quickstart;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author huey
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfiguration {

//    @Bean
//    public RedisSerializer springSessionDefaultRedisSerializer() {
//        return new GenericJackson2JsonRedisSerializer();
//    }

}
