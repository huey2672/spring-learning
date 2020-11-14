package com.huey.learning.springboot.web.httpmessageconvertersample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huey
 */
@Controller
public class HelloController {

    @PostMapping
    @ResponseBody
    public ResponseDTO service(@RequestBody RequestDTO request) {
        return new ResponseDTO();
    }

}
