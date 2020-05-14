package com.huey.learning.springframework.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huey
 */
@Service
public class BusinessService {

    @Autowired
    private BusinessDAO businessDAO;

    public String getCustomerName(Long customerId) {
        return businessDAO.getCustomerName(customerId);
    }

}
