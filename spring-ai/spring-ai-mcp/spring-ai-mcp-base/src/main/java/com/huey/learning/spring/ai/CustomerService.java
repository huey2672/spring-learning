package com.huey.learning.spring.ai;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Tool(description = "检索客户信息")
    Customer getCustomerInfo(@ToolParam(description = "客户ID") Long id) {
        return findCustomerById(id);
    }

    private Customer findCustomerById(Long id) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1001L, "李白", "13988880001"));
        customers.add(new Customer(1002L, "杜甫", "13988880002"));
        customers.add(new Customer(1003L, "白居易", "13988880003"));
        for (Customer customer : customers) {
            if (customer.id().equals(id)) {
                return customer;
            }
        }
        return null;
    }

}
