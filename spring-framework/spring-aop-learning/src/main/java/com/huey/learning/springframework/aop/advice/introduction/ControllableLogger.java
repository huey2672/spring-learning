package com.huey.learning.springframework.aop.advice.introduction;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.time.LocalDateTime;

/**
 * @author huey
 */
public class ControllableLogger extends DelegatingIntroductionInterceptor implements Loggable {

    private boolean loggerActive = false;

    @Override
    public void setLoggerActive(boolean active) {
        loggerActive = active;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {

        if (loggerActive) {
            System.out.printf("%s#%s is invoked at %s.\n",
                    mi.getClass().getSimpleName(), mi.getMethod().getName(), LocalDateTime.now());
        }

        return super.invoke(mi);

    }

}
