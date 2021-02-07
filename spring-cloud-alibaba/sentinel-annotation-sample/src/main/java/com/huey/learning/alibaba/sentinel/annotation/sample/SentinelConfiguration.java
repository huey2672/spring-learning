package com.huey.learning.alibaba.sentinel.annotation.sample;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huey
 */
@Configuration
public class SentinelConfiguration {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

    @PostConstruct
    public void initializeSentinelRules() {

        FlowRule rule = new FlowRule();
        rule.setResource("sayHello");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // set limit QPS to 20
        rule.setCount(20);
        List<FlowRule> rules = new ArrayList<>();
        rules.add(rule);

        FlowRuleManager.loadRules(rules);

    }

}
