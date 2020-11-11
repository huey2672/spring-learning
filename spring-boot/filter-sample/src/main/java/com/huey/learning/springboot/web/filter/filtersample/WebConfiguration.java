package com.huey.learning.springboot.web.filter.filtersample;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huey
 */
@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean<TransactionFilter> transactionFilter() {

        FilterRegistrationBean<TransactionFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new TransactionFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/service/*");

        return filterRegistrationBean;

    }

    @Bean
    public FilterRegistrationBean<LoggingFilter> loggingFilter() {

        FilterRegistrationBean<LoggingFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoggingFilter());
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;

    }

}
