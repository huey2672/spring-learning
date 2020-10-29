package com.huey.learning.springframework.web.client;

import com.huey.learning.springframework.web.Student;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huey
 */
public class RestTemplateTest {

    @Test
    public void testGetForObject() {

        String url = "http://localhost:8080/student/{studentId}.do";
        Long studentId = 123L;

        RestTemplate restTemplate = new RestTemplate();
        Student student = restTemplate.getForObject(url, Student.class, studentId);
        System.out.println(student);

    }

    @Test
    public void testGetForEntity() {

        String url = "http://localhost:8080/student/{studentId}.do";
        Map<String, Object> params = new HashMap<>();
        params.put("studentId", 123L);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Student> responseEntity = restTemplate.getForEntity(url, Student.class, params);

        String status = String.format("%d %s",
                responseEntity.getStatusCodeValue(), responseEntity.getStatusCode().getReasonPhrase());
        System.out.println("Status: " + status);

        Student student = responseEntity.getBody();
        System.out.println(student);

    }

    @Test
    public void testPostForEntity() {

        String url = "http://localhost:8080/student.do";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Student student = new Student();
        student.setStudentId(123L);
        student.setStudentName("Huey");
        student.setSex("M");

        HttpEntity<Student> request = new HttpEntity<>(student, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, request, String.class);

        String status = String.format("%d %s",
                responseEntity.getStatusCodeValue(), responseEntity.getStatusCode().getReasonPhrase());
        System.out.println("Status: " + status);

        String content = responseEntity.getBody();
        System.out.println("Content: " + content);

    }

}
