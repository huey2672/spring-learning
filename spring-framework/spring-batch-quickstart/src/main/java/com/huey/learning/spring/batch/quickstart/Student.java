package com.huey.learning.spring.batch.quickstart;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private String studentNbr;

    private String studentName;

    private String dateOfBirth;

    private String gender;

}
