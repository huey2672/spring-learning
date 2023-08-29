package com.huey.learning.springcloud.gateway.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class TimingGatewayFilterFactory extends AbstractGatewayFilterFactory<TimingGatewayFilterFactory.Config> {

    public TimingGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("headerName");
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            long startTime = System.currentTimeMillis();
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                exchange.getResponse().getHeaders().add(config.headerName, String.valueOf(elapsedTime));
            }));
        };
    }

    @Data
    public static class Config {
        private String headerName;
    }

}
