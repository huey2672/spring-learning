package com.huey.learning.spring.ai.toolcalling;

import org.springframework.ai.chat.model.ToolContext;
import org.springframework.ai.tool.annotation.Tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class CustomerTools {
    @Tool(description = "检索客户信息")
//    @Tool(description = "检索客户信息", returnDirect = true)
    Customer getCustomerInfo(Long id, ToolContext toolContext) {
        Map<String, Object> context = toolContext.getContext();
        return findCustomerById(id, String.valueOf(context.get("tenantId")));
    }

    private Customer findCustomerById(Long id, String tenantId) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1001L, "李白", "tang"));
        customers.add(new Customer(1002L, "杜甫", "tang"));
        customers.add(new Customer(1003L, "白居易", "tang"));
        customers.add(new Customer(1001L, "卫青", "han"));
        customers.add(new Customer(1002L, "霍去病", "han"));
        customers.add(new Customer(1003L, "李广", "han"));
        for (Customer customer : customers) {
            if (customer.id().equals(id) && customer.tenantId().equals(tenantId)) {
                return customer;
            }
        }
        return null;
    }

}
