package com.yr.springboot.demo03.service;

import com.yr.springboot.demo03.mybatis.mapper.UserTestMapper;
import com.yr.springboot.demo03.mybatis.pojo.UserTest;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @moduleName: UserServiceTest
 * @description: 测试
 * @author: 杨睿
 * @date: 2022-01-08 23:03
 **/
@Service
public class UserTestService implements ApplicationContextAware {
    @Autowired
    UserTestMapper userTestMapper;

    private ApplicationContext applicationContext = null;

    /**
     * 设置 IOC 容器
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int insertUsers(List<UserTest> userTestList) {
        int count = 0;

        // 从 IOC 容器中获取代理对象
        UserTestService  userService = applicationContext.getBean(UserTestService.class);
        for (UserTest user: userTestList) {
            count += userService.insertUser(user);
        }
        return count;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1, rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public int insertUser(UserTest user) {
        return userTestMapper.insertUser(user);
    }
    
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1, rollbackFor = Exception.class)
    public UserTest getUserTest(Long id) {

        return userTestMapper.selectUser(id);
    }


}
