package com.gd.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @DATA 2019-01-05 14:14
 * @Author zhangguowei  WeChat:17630376104
 * @Description TODO
 */
@Controller
public class TestController {

    @RequestMapping("/testThymeleaf")
    public String testThymeleaf() {

        return "TestThymeleaf";
    }
}
