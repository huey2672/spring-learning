package com.huey.learning.springframework.mvc.vo;

import lombok.Data;

@Data
public class ResponseVO<T> {

    private String code;

    private String desc;

    private T result;

    public static <T> ResponseVO buildSuccess(T result) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode("SUCCESS");
        responseVO.setResult(result);
        return responseVO;
    }

    public static ResponseVO buildFailure(Exception e) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode("FAILURE");
        responseVO.setDesc(e.getMessage());
        return responseVO;
    }

}