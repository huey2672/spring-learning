package com.huey.learning.springframework.aop.advisor.smmpa;

import com.huey.learning.springframework.aop.advisor.Seller;
import com.huey.learning.springframework.aop.advisor.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class StaticMethodMatcherPointcutAdvisorSample {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("advisor/smmpa/spring.xml");

        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("Huey");
        waiter.serveTo("Huey");

        Seller seller = (Seller) ctx.getBean("seller");
        seller.greetTo("Huey");

    }

}
