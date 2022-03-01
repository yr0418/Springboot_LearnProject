package com.yr.springboot.demo03.mybatis.pojo;

import java.io.Serializable;

public class Test2 implements Serializable {
    private Integer tNum;

    private String tName;

    private static final long serialVersionUID = 1L;

    public Integer gettNum() {
        return tNum;
    }

    public void settNum(Integer tNum) {
        this.tNum = tNum;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}