package com.huey.learning.spring.ioc.di.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class DependencyInjectionOfCollectionSample {

    public static void main(String[] args) {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("dependency-injection-collections/spring.xml");

        ComplexObjectOfList complexObjectOfList = appCtx.getBean(ComplexObjectOfList.class);
        System.out.println(complexObjectOfList);

        ComplexObjectOfSet complexObjectOfSet = appCtx.getBean(ComplexObjectOfSet.class);
        System.out.println(complexObjectOfSet);

        ComplexObjectOfMap complexObjectOfMap = appCtx.getBean(ComplexObjectOfMap.class);
        System.out.println(complexObjectOfMap);

        ComplexObjectOfProps complexObjectOfProps = appCtx.getBean(ComplexObjectOfProps.class);
        System.out.println(complexObjectOfProps);

    }

}
