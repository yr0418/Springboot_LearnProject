package com.yr.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @moduleName: TestController
 * @description: 测试类控制器
 * @author: 杨睿
 * @date: 2022-02-12 11:24
 **/
@RestController
@RequestMapping(value ="test")
public class TestController {

    @GetMapping(value = "test")
    public String test() {
        return "test";
    }
}
