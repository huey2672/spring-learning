package com.huey.learning.springframework.aop.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author huey
 */
public class TimingInvocationHandler implements InvocationHandler {

    private Object target;

    public TimingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long start = System.nanoTime();

        Object rtnObj = method.invoke(target, args);

        long finish = System.nanoTime();
        System.out.printf("Executing %s finished in %s ns.\n",
                target.getClass().getSimpleName() + "#" + method.getName(),
                finish - start);

        return rtnObj;

    }

}
