package com.huey.learning.springframework.aop.autoproxycreator;

import com.huey.learning.springframework.aop.advisor.Seller;
import com.huey.learning.springframework.aop.advisor.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class BeanNameAutoProxyCreatorSample {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("auto-proxy-creator/bean-name/spring.xml");

        Waiter waiter = ctx.getBean(Waiter.class);
        waiter.greetTo("Huey");

        Seller seller = ctx.getBean(Seller.class);
        seller.greetTo("Huey");

    }

}
