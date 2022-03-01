package com.yr.springboot.demo02.service;

import com.yr.springboot.demo02.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {
  @Override
  public boolean validator(User user) {
    System.out.println("引入新的接口" + UserValidator.class.getSimpleName());
    return user!=null;
  }
}
