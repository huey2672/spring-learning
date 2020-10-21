package com.huey.learning.springframework.aop.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimingProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class<?> clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        long start = System.nanoTime();

        Object rtnObj = proxy.invokeSuper(target, args);

        long finish = System.nanoTime();
        System.out.printf("Executing %s finished in %s ns.\n",
                target.getClass().getSimpleName() + "#" + method.getName(),
                finish - start);

        return rtnObj;

    }

}