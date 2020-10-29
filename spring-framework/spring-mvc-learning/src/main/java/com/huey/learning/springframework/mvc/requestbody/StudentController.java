package com.huey.learning.springframework.mvc.requestbody;

import com.huey.learning.springframework.mvc.entity.Student;
import com.huey.learning.springframework.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "success";
    }

    @RequestMapping(path = "/{studentId}", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent(@PathVariable("studentId") Long studentId) {
        return studentService.getStudent(studentId);
    }

}