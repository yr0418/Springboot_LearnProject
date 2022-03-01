package com.yr.springboot.demo02.manyAspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;


/**
 * @moduleName: Aspect01
 * @description: 切面测试
 * @author: 杨睿
 * @date: 2022-01-08 21:49
 **/
@Aspect
@Order(2)
public class Aspect02 {
    @Pointcut("execution(* com.yr.springboot.demo02.service.TestService.test(..))")
    public void pointCut() { }

    @Before("pointCut()")
    public void before() {
        System.out.println("Aspect02 before...");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("Aspect02 after...");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("Aspect02 afterReturning...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("Aspect02 afterThrowing...");
    }
}
