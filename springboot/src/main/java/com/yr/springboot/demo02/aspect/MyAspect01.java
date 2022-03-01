package com.yr.springboot.demo02.aspect;

import org.aspectj.lang.annotation.*;

/**
 * @moduleName: MyAspect01
 * @description: 切面测试实例01
 * @author: 杨睿
 * @date: 2022-01-06 23:33
 **/

/**
 * Aspect：声明这是一个切面
 * 未加入around 通知，本切面约定流程如下：
 * 1.先执行 @Before
 * 2.执行 @After
 * 3.未出现异常，执行 @AfterReturning，出现异常，执行 @AfterThrowing
 */
//@Aspect
public class MyAspect01 {
    /**
     * 定义切点，设置正则表达式，注明什么方法才启用 AOP
     * 正则表达式：execution(* com.yr.springboot.demo02.service.UserServiceImpl.printUser(..))
     * execution：在执行时，拦截里面的正则匹配方法
     * * ：表示返回任意类型的方法
     * com.yr.springboot.demo02.service.UserServiceImpl：指定目标对象的全限定名称
     * printUser：指定目标对象的方法
     * (..)：任意参数进行匹配
     */
    @Pointcut("execution(* com.yr.springboot.demo02.service.User02ServiceImpl.printUser(..))")
    public void pointCut(){ }

    /**
     * 引入 pointCut 参数，指明什么方法才使用 Before
     * @Before("execution(* com.yr.springboot.demo02.service.UserServiceImpl.printUser(..))")
     * 等价于 @Before("pointCut()")
     */
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
