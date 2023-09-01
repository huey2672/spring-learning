package com.huey.learning.spring.integration.quickstart;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {

    private Long orderId;

    // other order properties

}
