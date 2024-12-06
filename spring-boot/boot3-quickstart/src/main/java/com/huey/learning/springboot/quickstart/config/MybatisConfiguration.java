package com.huey.learning.springboot.quickstart.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.huey.learning.springboot.quickstart.mapper")
public class MybatisConfiguration {
    
}