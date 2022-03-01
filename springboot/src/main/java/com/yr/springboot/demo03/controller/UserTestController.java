package com.yr.springboot.demo03.controller;

import com.yr.springboot.demo03.mybatis.pojo.UserTest;
import com.yr.springboot.demo03.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @moduleName: UserTestController
 * @description: test
 * @author: 杨睿
 * @date: 2022-01-08 23:05
 **/
@RestController
@RequestMapping(value="userTest")
public class UserTestController {
    @Autowired
    UserTestService userTestService = null;

    @PostMapping(value = "insert")
    public Map<String, Object> insertUser(UserTest user) {
        int update = userTestService.insertUser(user);
        Map<String, Object> result = new HashMap<>();
        result.put("success", update == 1);
        result.put("user", user);
        return result;
    }

    @GetMapping(value = "getUser")
    public UserTest getUser(Long id) {
        return userTestService.getUserTest(id);
    }
}
