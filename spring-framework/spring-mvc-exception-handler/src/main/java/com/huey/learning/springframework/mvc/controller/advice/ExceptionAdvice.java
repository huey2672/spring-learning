package com.huey.learning.springframework.mvc.controller.advice;

import com.huey.learning.springframework.mvc.vo.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(
        // scan the controllers in the specified packages
        basePackages = "com.huey.learning.springframework.mvc.controller.*",
        // only advice the controllers that are annotated with @RestController
        annotations = RestController.class
)
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVO exception(Exception e) {
        return ResponseVO.buildFailure(e);
    }

}