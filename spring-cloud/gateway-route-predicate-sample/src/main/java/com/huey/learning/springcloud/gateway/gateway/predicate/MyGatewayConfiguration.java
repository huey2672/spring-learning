package com.huey.learning.springcloud.gateway.gateway.predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyGatewayConfiguration {

    @Bean
    public VipRoutePredicateFactory vipRoutePredicateFactory(VipService vipService) {
        return new VipRoutePredicateFactory(vipService);
    }

}
