package com.huey.learning.springboot.web.httpmessageconvertersample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

/**
 * @author huey
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Student {

    private Long studentId;

    private String studentName;

    private LocalDate dateOfBirth;


}
