package com.yr.springboot.demo03.mybatis.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserTest implements Serializable {

    private Long id;

    private String username;

    private String note;

    private static final long serialVersionUID = 1L;

}