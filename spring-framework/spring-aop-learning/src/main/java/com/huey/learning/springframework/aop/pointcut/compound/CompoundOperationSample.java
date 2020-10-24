package com.huey.learning.springframework.aop.pointcut.compound;

import com.huey.learning.springframework.aop.pointcut.annotation.ApplicationConfiguration;
import com.huey.learning.springframework.aop.pointcut.annotation.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huey
 */
public class CompoundOperationSample {

    public static void main(String[] args) {

        ApplicationContext appCtx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        HelloService helloService = appCtx.getBean(HelloService.class);

        helloService.sayHello("Huey");
        helloService.sayGoodbye("Huey");

    }

}
