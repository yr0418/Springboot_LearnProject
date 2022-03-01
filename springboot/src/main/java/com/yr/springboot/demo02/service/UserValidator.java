package com.yr.springboot.demo02.service;

import com.yr.springboot.demo02.pojo.User;
import org.springframework.stereotype.Component;

@Component
public interface UserValidator {
  public boolean validator(User user);
}
