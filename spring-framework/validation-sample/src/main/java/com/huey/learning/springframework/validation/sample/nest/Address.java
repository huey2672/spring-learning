package com.huey.learning.springframework.validation.sample.nest;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Address {

    @NotBlank
    private String province;

    @NotBlank
    private String city;

    @NotBlank
    private String street;

}
