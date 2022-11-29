package com.huey.learning.springframework.validation.sample.custom;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Member {

    @NotBlank
    private String name;

    @PhoneNumber
    private String phone;

}
