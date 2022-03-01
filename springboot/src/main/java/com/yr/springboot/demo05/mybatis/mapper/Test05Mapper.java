package com.yr.springboot.demo05.mybatis.mapper;

import com.yr.springboot.demo05.mybatis.pojo.Test05;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Alone-Wolf
 */
@Mapper
public interface Test05Mapper {

    int deleteByPrimaryKey(Long id);

    int insert(Test05 record);

    Test05 selectByPrimaryKey(Long id);

    List<Test05> selectAll();

    List<Test05> findUsers(@Param("username") String username,@Param("note")String note);

    int updateByPrimaryKey(Test05 record);
}