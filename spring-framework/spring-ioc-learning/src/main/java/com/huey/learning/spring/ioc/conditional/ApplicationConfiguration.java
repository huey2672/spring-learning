package com.huey.learning.spring.ioc.conditional;

import com.huey.learning.spring.ioc.conditional.component.ListService;
import com.huey.learning.spring.ioc.conditional.component.UnixListService;
import com.huey.learning.spring.ioc.conditional.component.WindowsListService;
import com.huey.learning.spring.ioc.conditional.condition.UnixCondition;
import com.huey.learning.spring.ioc.conditional.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author huey
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    @Conditional(UnixCondition.class)
    public ListService unixListService() {
        return new UnixListService();
    }

    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsListService() {
        return new WindowsListService();
    }

}
