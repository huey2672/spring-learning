package com.huey.learning.springboot.quickstart.properties.nested;

import lombok.Data;

/**
 * @author huey
 */
@Data
public class Credentials {

    private String authMethod;
    private String username;
    private String password;

}
