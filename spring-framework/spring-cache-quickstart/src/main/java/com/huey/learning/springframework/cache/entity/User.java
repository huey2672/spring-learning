package com.huey.learning.springframework.cache.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author huey
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private String userId;

    // other fields

}
