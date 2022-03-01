package com.yr.springboot;

import com.yr.springboot.demo02.aspect.MyAspect02;
import com.yr.springboot.demo02.manyAspect.Aspect01;
import com.yr.springboot.demo02.manyAspect.Aspect02;
import com.yr.springboot.demo02.manyAspect.Aspect03;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;


@SpringBootApplication
@MapperScan(value = "com.yr.springboot")
//@EnableCaching
public class SpringbootApplication {

    /**
     * 定义切面
     */
//  @Bean(name = "MyAspect01")
//  public MyAspect01 initMyAspect01 () {
//    return new MyAspect01();
//  }

    @Bean(name = "MyAspect02")
    public MyAspect02 initMyAspect02 () {
        return new MyAspect02();
    }

//  @Bean(name = "MyAspect03")
//  public MyAspect03 initMyAspect03 () {
//    return new MyAspect03();
//  }
//
//  @Bean(name = "MyAspect04")
//  public MyAspect04 initMyAspect04 () {
//    return new MyAspect04();
//  }

    @Bean(name = "Aspect01")
    public Aspect01 initAspect01 () {
        return new Aspect01();
    }

    @Bean(name = "Aspect02")
    public Aspect02 initAspect02 () {
        return new Aspect02();
    }

    @Bean(name = "Aspect03")
    public Aspect03 initAspect03 () {
        return new Aspect03();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Autowired
    PlatformTransactionManager transactionManager;

    @PostConstruct
    public void viewTransactionManager() {
        System.out.println(transactionManager.getClass().getName());
    }

}
