package com.huey.learning.springframework.aop.aspectj.pointcut.named;

import org.aspectj.lang.annotation.Pointcut;

public class LogPointcut {

    @Pointcut("within(com.huey.learning.springframework.aop..*)")
    private void inPackage() {
    }

    @Pointcut("execution(* sayHello(..))")
    private void sayHello() {
    }

    @Pointcut("inPackage() && sayHello()")
    public void inPkgSayHello() {
    }

}