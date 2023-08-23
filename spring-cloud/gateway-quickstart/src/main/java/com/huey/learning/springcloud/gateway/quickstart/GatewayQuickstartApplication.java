package com.huey.learning.springcloud.gateway.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayQuickstartApplication {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route",
                        r -> r.path("/example")
                                .uri("http://example.com")
                )
                .route("query_route",
                        r -> r.query("foo", "Foo")
                                .filters(f -> f.addResponseHeader("X-Bar", "Bar"))
                                .uri("http://www.baeldung.com/"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayQuickstartApplication.class, args);
    }

}
