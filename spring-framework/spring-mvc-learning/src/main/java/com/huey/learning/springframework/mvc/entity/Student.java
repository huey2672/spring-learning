package com.huey.learning.springframework.mvc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
	
	private Long studentId;

	private String studentName;

	private String sex;

	private Date dateOfBirth;

}