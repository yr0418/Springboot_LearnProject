package com.yr.springboot.demo03.mybatis.mapper;

import com.yr.springboot.demo03.mybatis.pojo.Test2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Test2Mapper {
    int deleteByPrimaryKey(Integer tNum);

    int insert(Test2 record);

    Test2 selectByPrimaryKey(Integer tNum);

    List<Test2> selectAll();

    int updateByPrimaryKey(Test2 record);
}