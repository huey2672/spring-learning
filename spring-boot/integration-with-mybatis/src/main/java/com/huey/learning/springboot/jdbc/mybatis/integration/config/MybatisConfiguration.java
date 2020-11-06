package com.huey.learning.springboot.jdbc.mybatis.integration.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author huey
 */
@Configuration
@MapperScan(basePackages = "com.huey.learning.springboot.jdbc.mybatis.integration.mapper")
public class MybatisConfiguration {
}
