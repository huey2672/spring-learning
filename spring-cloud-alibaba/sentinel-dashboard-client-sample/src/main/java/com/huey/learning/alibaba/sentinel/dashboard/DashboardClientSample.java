package com.huey.learning.alibaba.sentinel.dashboard;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
public class DashboardClientSample {

    public static void main(String[] args) {

        initFlowRules();

        while (true) {

            try (Entry entry = SphU.entry("DashboardClientSample")) {
                // 被保护的逻辑
                System.out.println("Hello, Sentinel!");
            }
            catch (BlockException e) {
                // 处理被流控的逻辑
                System.out.println("BLOCKED!");
            }

            try {
                TimeUnit.MILLISECONDS.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * initial flow rules
     */
    private static void initFlowRules() {

        FlowRule rule = new FlowRule();
        rule.setResource("DashboardClientSample");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // set limit QPS to 20
        rule.setCount(20);
        List<FlowRule> rules = new ArrayList<>();
        rules.add(rule);

        FlowRuleManager.loadRules(rules);

    }

}
