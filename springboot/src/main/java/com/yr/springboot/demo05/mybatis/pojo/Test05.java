package com.yr.springboot.demo05.mybatis.pojo;

import java.io.Serializable;

/**
 * @author Alone-Wolf
 */
public class Test05 implements Serializable {
    private Long id;

    private String username;

    private String note;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}