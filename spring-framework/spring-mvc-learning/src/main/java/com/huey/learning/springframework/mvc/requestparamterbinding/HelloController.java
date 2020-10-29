package com.huey.learning.springframework.mvc.requestparamterbinding;

import com.huey.learning.springframework.mvc.entity.Student;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Controller("HelloController1")
public class HelloController {

    @RequestMapping(path = "/hello1", method = RequestMethod.POST)
    public String hello1(@RequestBody String content) throws IOException {
        System.out.println("content: " + content);
        return "hello";
    }

    @RequestMapping("/hello2")
    public String hello2(Student student) {
        System.out.println("student: " + student);
        return "hello";
    }

    @RequestMapping("/hello3")
    public String hello3(@RequestParam("stringParam") String strParam,
                         @RequestParam(value = "intParam", defaultValue = "123") Integer intParam) {
        System.out.println("strParam: " + strParam);
        System.out.println("intParam: " + intParam);
        return "hello";
    }

    @RequestMapping("/hello4/{name}")
    public String hello4(@PathVariable("name") String name) {
        System.out.println("hello, " + name + "!");
        return "hello";
    }

    @RequestMapping("/hello5")
    public String hello5(@RequestHeader(value = "User-Agent", required = false) String userAgent) {
        System.out.println("User-Agent: " + userAgent);
        return "hello";
    }

    @RequestMapping("/hello6")
    public String hello6(@CookieValue(value = "JSESSIONID", required = false) String jSessionId) {
        System.out.println("JSESSIONID: " + jSessionId);
        return "hello";
    }

    @RequestMapping("/hello7")
    public String hello7(HttpServletRequest request) {

        // do something with request...

        return "hello";
    }

    @RequestMapping("/hello8")
    public void hello8(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(request.getQueryString());
    }

    @RequestMapping("/hello9")
    public String hello9(HttpSession session) {
        System.out.println("sessionId: " + session.getId());
        return "hello";
    }

    @RequestMapping("/hello")
    public String hello(WebRequest request) {
        System.out.println("description: " + request.getDescription(true));
        return "hello";
    }

    @RequestMapping("/inputStream")
    public String testInputStream(InputStream inputStream) throws IOException {
        // 读取输入流的内容
//        System.out.println("inputStream: " + IOUtils.toString(inputStream));
        return "hello";
    }

    @RequestMapping("/outputStream")
    public void testOutputStream(OutputStream outputStream) throws IOException {
        // 读取类路径下的图片文件
        Resource resource = new ClassPathResource("/image/test.jpg");
        // 将图片写到输出流中
        FileCopyUtils.copy(resource.getInputStream(), outputStream);
    }

}