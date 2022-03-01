package com.yr.springboot.demo02.manyAspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;


/**
 * @moduleName: Aspect01
 * @description: 切面测试
 * @author: 杨睿
 * @date: 2022-01-08 21:49
 **/
@Aspect
@Order(1)
public class Aspect01 {

    @Pointcut("execution(* com.yr.springboot.demo02.service.TestService.test(..))")
    public void pointCut() { }

    @Before("pointCut()")
    public void before() {
        System.out.println("Aspect01 before...");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("Aspect01 after...");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("Aspect01 afterReturning...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("Aspect01 afterThrowing...");
    }
}
