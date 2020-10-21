package com.huey.learning.springframework.aop.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author huey
 */
public class JdkDynamicProxySample {

    public static void main(String[] args) {

        HelloService target = new HelloServiceImpl();
        InvocationHandler handler = new TimingInvocationHandler(target);
        HelloService proxy = (HelloService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);

        proxy.sayHello("Huey");
        proxy.sayGoodbye("Huey");

    }

}
