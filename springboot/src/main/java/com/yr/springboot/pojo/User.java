package com.yr.springboot.pojo;

import com.yr.springboot.demo06.pojo.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * @moduleName: Test06
 * @description: MongoDB测试POJO
 * @author: 杨睿
 * @date: 2022-02-09 14:23
 **/

// Document 注解，标识为 MongoDB文档
@Document
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -7895435231819517614L;

    @Id
    private Long id;

    /**
     * Field 注解，即在 MongoDB 中，使用 “username” 保存属性
     */
    @Field("username")
    private String username;

    private String note;

    private List<Role> roles;
}
