package com.huey.learning.springframework.aop.advisor.smmpa;

import com.huey.learning.springframework.aop.advisor.Waiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

    @Override
    public ClassFilter getClassFilter() {
        return Waiter.class::isAssignableFrom;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "greetTo".equals(method.getName());
    }

}