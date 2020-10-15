package com.huey.learning.spring.ioc.lazyinit;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author huey
 */
@Component
@Lazy
public class LazyComponent {

    public LazyComponent() {
        System.out.println("In LazyComponent Constructor.");
    }

}
