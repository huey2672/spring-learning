package com.huey.learning.springframework.mvc.controller;

import java.util.Collections;

import com.huey.learning.springframework.mvc.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(path = "/hello")
    public ResponseVO hello() {
        Collections.EMPTY_LIST.get(1);
        return ResponseVO.buildSuccess("Hello");
    }

}