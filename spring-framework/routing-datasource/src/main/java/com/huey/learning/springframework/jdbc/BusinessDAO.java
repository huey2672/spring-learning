package com.huey.learning.springframework.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author huey
 */
@Repository
public class BusinessDAO {

    private final static String CUSTOMER_NAME_QUERY_SQL = "SELECT CUST_NAME FROM CUSTOMER WHERE CUST_ID = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public String getCustomerName(Long customerId) {

        Object[] queryParams = new Object[]{customerId};
        List<String> customerNames = jdbcTemplate.query(CUSTOMER_NAME_QUERY_SQL, queryParams, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("CUST_NAME");
            }
        });

        return customerNames != null && !customerNames.isEmpty() ? customerNames.get(0) : null;

    }

}
