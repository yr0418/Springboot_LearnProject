package com.yr.springboot.demo02.service;

import com.yr.springboot.demo02.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @moduleName: testService
 * @description: 测试服务类
 * @author: 杨睿
 * @date: 2022-01-08 20:15
 **/
@Service
public class TestService {

    public void printUser(User user) {
        if (user == null) {
            throw new RuntimeException("检查 参数user 是否为 null");
        }
        System.out.println("id = " + user.getId());
        System.out.println("username  = " + user.getName());
    }

    public void test() {
        System.out.println("多个切面测试...");
    }
}
