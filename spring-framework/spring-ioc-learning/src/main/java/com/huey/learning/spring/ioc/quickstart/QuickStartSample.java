package com.huey.learning.spring.ioc.quickstart;

import com.huey.learning.spring.ioc.quickstart.bean.ExampleBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class QuickStartSample {

    public static void main(String[] args) throws Exception {

        // creates an application content
        AbstractApplicationContext appCtx = new ClassPathXmlApplicationContext("quick-start/spring.xml");

        // starts the application content
        appCtx.start();

        // gets a bean from the ioc container
        ExampleBean example = appCtx.getBean("example", ExampleBean.class);

        // does something with the bean
        System.out.println(example);


        // stops the application content
        appCtx.stop();


        AbstractApplicationContext appCtx2 = new ClassPathXmlApplicationContext("services.xml", "daos.xml");

    }

}
