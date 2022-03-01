package com.yr.springboot.demo06.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @moduleName: Role
 * @description: MongoDB测试POJO
 * @author: 杨睿
 * @date: 2022-02-09 14:30
 **/
@Data
@Document
public class Role {
    private Long id;

    @Field("role_name")
    private String roleName;

    private String note;
}
