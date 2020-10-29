package com.huey.learning.springframework.mvc.requestbody;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class HelloController {

    @RequestMapping(path="/hello", method=RequestMethod.POST)
    public String hello(@RequestBody String content) throws IOException {
        System.out.println("content: " + content);
        return "hello";
    }

}