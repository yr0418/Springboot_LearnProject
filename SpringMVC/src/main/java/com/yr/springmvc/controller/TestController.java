package com.yr.springmvc.controller;

import com.yr.springmvc.mybatis.pojo.User;
import com.yr.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.StoredProcedureParameter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @moduleName: TestController
 * @description: 测试类控制器
 * @author: 杨睿
 * @date: 2022-02-12 11:24
 **/
@RestController
@RequestMapping(value ="test")
public class TestController {

    @Autowired
    UserService userService;
    
    @GetMapping(value = "test")
    public Map<String, Object> test(
            @RequestParam(name = "int_val", required = false, defaultValue = "0")Integer intVal,
            @RequestParam(name = "long_val", required = true, defaultValue = "0")Long longVal,
            @RequestParam(name = "string_val", required = false, defaultValue = "null")String stringVal) {
        Map<String, Object> map = new HashMap<>();
        map.put("intVal", intVal);
        map.put("longVal", longVal);
        map.put("stringVal", stringVal);
        return map;
    }
    
    @PutMapping(value = "insert")
    public User insert(@RequestBody User user) {
        userService.insert(user);
        return user;
    }

    @GetMapping(value = "/{id}")
    public User get(@PathVariable(name = "id") Long id) {
        return userService.getById(id);
    }

    @PostMapping(value = "format")
    public Map<String, Object> format(@RequestBody Date date, Double num) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(date);
        System.out.println(num);
        map.put("date", date);
        map.put("num", num);
        return map;
    }
}
