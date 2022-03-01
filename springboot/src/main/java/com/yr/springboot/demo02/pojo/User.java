package com.yr.springboot.demo02.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
  private String name;
  private String id;
}
