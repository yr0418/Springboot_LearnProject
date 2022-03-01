package com.yr.springboot.demo02.service;

import com.yr.springboot.demo02.pojo.User;

public class User02ServiceImpl implements User02Service {
  @Override
  public void printUser(User user) {
    if (user==null){
      throw new RuntimeException("检查 参数user 是否为 null");
    }
    System.out.println("id = " + user.getId());
    System.out.println("username  = " + user.getName());

  }
}
