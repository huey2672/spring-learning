package com.huey.learning.springboot.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Hello World Controller
 *
 * @author huey
 */
@Controller
public class HelloWorldController {

    @RequestMapping("helloWorld")
    public String helloWorld(Model model) {
        model.addAttribute("title", "Hello, Thymeleaf");
        model.addAttribute("message", "This is my first thymeleaf page.");
        return "hello-world";
    }

}
