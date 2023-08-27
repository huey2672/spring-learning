package com.huey.learning.springcloud.gateway.gateway.predicate;

import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.HttpCookie;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;


/**
 * @author huey
 */
public class VipRoutePredicateFactory extends AbstractRoutePredicateFactory<VipRoutePredicateFactory.Config> {

    private final VipService vipService;

    public VipRoutePredicateFactory(VipService vipService) {
        super(VipRoutePredicateFactory.Config.class);
        this.vipService = vipService;
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("isVip");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            boolean isBetaUser = false;
            HttpCookie cookie = exchange.getRequest().getCookies().getFirst("userId");
            if (cookie != null) {
                String userId = cookie.getValue();
                isBetaUser = vipService.isVip(userId);
            }
            return Boolean.parseBoolean(config.isVip) == isBetaUser;
        };
    }

    @Data
    @Validated
    public static class Config {
        @NotEmpty
        private String isVip;
    }

}
