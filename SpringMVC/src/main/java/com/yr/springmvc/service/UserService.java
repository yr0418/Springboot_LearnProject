package com.yr.springmvc.service;

import com.yr.springmvc.mybatis.mapper.UserMapper;
import com.yr.springmvc.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @moduleName: UserService
 * @description: 用户服务类
 * @author: 杨睿
 * @date: 2022-03-06 16:48
 **/
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public int insert(User user) {
        return userMapper.insert(user);
    }

    public User getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
