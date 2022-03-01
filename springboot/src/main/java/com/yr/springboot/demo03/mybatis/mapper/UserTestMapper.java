package com.yr.springboot.demo03.mybatis.mapper;

import com.yr.springboot.demo03.mybatis.pojo.UserTest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTestMapper {
    /**
     * 插入实例
     * @param user
     * @return 是否插入
     */
    int insertUser(UserTest user);

    /**
     * 查询实例
     * @param id
     * @return 用户实例
     */
    UserTest selectUser(Long id);


}