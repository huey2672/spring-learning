package com.huey.learning.spring.resources.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "helloServlet", urlPatterns = {"/hello.svg"})
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Resource resource = new ServletContextResource(req.getServletContext(), "/images/spring.svg");
        InputStream inStream = resource.getInputStream();
        byte[] byteArray = IOUtils.toByteArray(inStream);
        resp.getOutputStream().write(byteArray);
    }

}