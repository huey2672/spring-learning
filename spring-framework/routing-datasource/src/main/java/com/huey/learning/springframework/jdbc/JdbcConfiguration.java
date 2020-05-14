package com.huey.learning.springframework.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huey
 */
@Configuration
@ImportResource("classpath:spring/spring-jdbc.xml")
public class JdbcConfiguration {

    @Bean
    public DataSource dataSource(DataSource eastRegionDataSource, DataSource westRegionDataSource) {

        // creates a map of target data sources with the lookup key as key
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(Region.EAST, eastRegionDataSource);
        targetDataSources.put(Region.WEST, westRegionDataSource);

        AbstractRoutingDataSource regionRoutingDatasource = new RegionDataSourceRouter();
        // specifies the map of target data sources
        regionRoutingDatasource.setTargetDataSources(targetDataSources);
        // specifies the default target data sources
        regionRoutingDatasource.setDefaultTargetDataSource(eastRegionDataSource);

        return regionRoutingDatasource;

    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
