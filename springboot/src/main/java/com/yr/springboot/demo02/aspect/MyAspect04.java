package com.yr.springboot.demo02.aspect;

import org.aspectj.lang.annotation.*;

/**
 * @moduleName: MyAspect04
 * @description: 切面测试
 * @author: 杨睿
 * @date: 2022-01-08 20:13
 **/

//@Aspect
public class MyAspect04 {

    @Pointcut("execution(* com.yr.springboot.demo02.service.TestService.printUser(..))")
    public void pointCut(){ }

    @Before("pointCut()")
    public void before() {
        System.out.println("before...");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after...");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }
}
