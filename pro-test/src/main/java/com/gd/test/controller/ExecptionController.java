package com.gd.test.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @DATA 2019-01-05 14:58
 * @Author zhangguowei  WeChat:17630376104
 * @Description TODO
 */
@ControllerAdvice
public class ExecptionController {


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object execption(Exception ex, HttpServletRequest request) {
        ex.printStackTrace();
        Map map = new HashMap();
        map.put("code", 500);
        map.put("msg", ex.getMessage());
        map.put("url", request.getRequestURL());
        return map;

    }
}
