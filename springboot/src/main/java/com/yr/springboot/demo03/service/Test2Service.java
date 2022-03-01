package com.yr.springboot.demo03.service;

import com.yr.springboot.demo03.mybatis.mapper.Test2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @moduleName: Test2Service
 * @description: 测试服务类
 * @author: 杨睿
 * @date: 2022-01-13 14:57
 **/

@Service
public class Test2Service {
    @Autowired
    Test2Mapper test2Mapper;
}
