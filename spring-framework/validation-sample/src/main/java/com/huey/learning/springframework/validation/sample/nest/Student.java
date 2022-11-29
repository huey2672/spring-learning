package com.huey.learning.springframework.validation.sample.nest;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Student {

    @NotBlank
    private String studentNo;

    @NotBlank
    private String studentName;

    @Valid
    @NotNull
    private Address address;

}
