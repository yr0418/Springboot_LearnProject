package com.yr.springmvc.mybatis.pojo;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    @Id
    private Long id;

    private String username;

    private String note;

    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}