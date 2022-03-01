package com.yr.springboot.demo02.controller;

import com.yr.springboot.demo02.pojo.User;
import com.yr.springboot.demo02.service.User02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @moduleName: UserController
 * @description: userController测试用例
 * @author: 杨睿
 * @date: 2022-01-06 23:42
 **/
@RestController
@RequestMapping(value = "user02")
public class User02Controller {
    @Autowired
    private User02Service userService = null;

    @GetMapping(value = "getUser")
    public User getUser(String id, String username) {
        User user = new User();
        user.setName(username);
        user.setId(id);
        userService.printUser(user);
        return user;
    }
}
