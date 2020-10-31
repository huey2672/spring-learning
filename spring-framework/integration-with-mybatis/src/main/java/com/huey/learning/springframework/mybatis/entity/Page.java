package com.huey.learning.springframework.mybatis.entity;

import lombok.Data;

import java.util.List;

/**
 * @author huey
 */
@Data
public class Page<T> {

    private int total;

    private List<T> resultList;

}
