package com.huey.learning.springframework.aop.dynamicproxy.cglib;

/**
 * @author huey
 */
public class CglibProxySample {

    public static void main(String[] args) {

        TimingProxy proxy = new TimingProxy();
        HelloService helloService = (HelloServiceImpl) proxy.getProxy(HelloServiceImpl.class);

        helloService.sayHello("Huey");
        helloService.sayGoodbye("Huey");

    }

}
