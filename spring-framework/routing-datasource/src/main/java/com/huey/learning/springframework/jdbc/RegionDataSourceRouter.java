package com.huey.learning.springframework.jdbc;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author huey
 */
public class RegionDataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {

        // chooses the region to be the current lookup key
        return RegionContextHolder.get();

    }

}
