package com.huey.learning.spring.session.quickstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huey
 */
@RestController
@RequestMapping("session")
public class SessionController {

    @GetMapping("attributes")
    public Map<String, Object> attributes(HttpServletRequest request, HttpSession session) {

        Map<String, Object> attributes = new HashMap<>();

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            String parameterValue = request.getParameter(parameterName);
            session.setAttribute(parameterName, parameterValue);
        }


        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attribute = session.getAttribute(attributeName);
            attributes.put(attributeName, attribute);
        }

        return attributes;

    }

}
