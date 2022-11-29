package com.huey.learning.springframework.validation.sample.group;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
public class Student {

    @Null(message = "studentNo is unnecessary", groups = Add.class)
    @NotBlank(message = "studentNo is mandatory", groups = Update.class)
    private String studentNo;

    @NotBlank(message = "studentName is mandatory", groups = Add.class)
    private String studentName;

}
