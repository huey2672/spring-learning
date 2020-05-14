package com.huey.learning.springframework.jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author huey
 */
public class MainApp {

    public static void main(String[] args) {

        // gets the region from request or session
        Region region = Region.WEST;
        // gets the query condition from request or session
        Long queryCustomerId = 1L;

        // sets the region, you can change the region and compare the outputs.
        RegionContextHolder.set(region);

        // creates a spring application context
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class, JdbcConfiguration.class);

        // calls the business service
        BusinessService businessService = context.getBean(BusinessService.class);
        String customerName = businessService.getCustomerName(queryCustomerId);
        System.out.println(customerName);

        // closes the spring application context
        context.close();

        // clears the region context
        RegionContextHolder.clear();
    }

}
