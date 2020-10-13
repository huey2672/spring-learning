package com.huey.learning.spring.ioc.di.collections;

import com.huey.learning.spring.ioc.di.Weapon;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huey
 */
public class DependencyInjectionOfCollectionSample {

    public static void main(String[] args) {

        AbstractApplicationContext appCtx = new ClassPathXmlApplicationContext("dependency-injection-collections/spring.xml");
        appCtx.start();

        ComplexObjectOfList complexObjectOfList = appCtx.getBean(ComplexObjectOfList.class);
        System.out.println(complexObjectOfList);

        ComplexObjectOfSet complexObjectOfSet = appCtx.getBean(ComplexObjectOfSet.class);
        System.out.println(complexObjectOfSet);

        ComplexObjectOfMap complexObjectOfMap = appCtx.getBean(ComplexObjectOfMap.class);
        System.out.println(complexObjectOfMap);

        ComplexObjectOfProps complexObjectOfProps = appCtx.getBean(ComplexObjectOfProps.class);
        System.out.println(complexObjectOfProps);

        appCtx.stop();

    }

}
