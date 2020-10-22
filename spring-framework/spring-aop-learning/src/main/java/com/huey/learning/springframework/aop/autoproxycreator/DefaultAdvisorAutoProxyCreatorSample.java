package com.huey.learning.springframework.aop.autoproxycreator;

import com.huey.learning.springframework.aop.advisor.Seller;
import com.huey.learning.springframework.aop.advisor.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class DefaultAdvisorAutoProxyCreatorSample {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("auto-proxy-creator/default-advisor/spring.xml");

        Waiter waiter = ctx.getBean(Waiter.class);
        waiter.greetTo("Huey");
        waiter.serveTo("Huey");

        Seller seller = ctx.getBean(Seller.class);
        seller.greetTo("Huey");

    }

}
