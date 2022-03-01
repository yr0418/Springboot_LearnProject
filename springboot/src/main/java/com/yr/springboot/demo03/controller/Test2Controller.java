package com.yr.springboot.demo03.controller;

import com.yr.springboot.demo03.service.Test2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @moduleName: Test2Controller
 * @description: 测试控制类
 * @author: 杨睿
 * @date: 2022-01-13 15:01
 **/
@RestController
@RequestMapping(value = "test2")
public class Test2Controller {
    @Autowired
    Test2Service test2Service;

}
