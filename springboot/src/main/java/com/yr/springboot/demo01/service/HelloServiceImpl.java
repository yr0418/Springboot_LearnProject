package com.yr.springboot.demo01.service;

/**
 * @description: 简易接口 HelloService 的实现类
 */

public class HelloServiceImpl implements HelloService {
  @Override
  public void sayHello(String name) {
    if (name==null || name.trim()==""){
      throw new RuntimeException("parameter is null");
    }
    System.out.println("hello,"+name);
  }
}
