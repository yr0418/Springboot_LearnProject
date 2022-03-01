package com.yr.springboot.demo02.aspect;

import com.yr.springboot.demo02.pojo.User;
import com.yr.springboot.demo02.service.UserValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @moduleName: MyAspect03
 * @description: 切面测试类
 * @author: 杨睿
 * @date: 2022-01-08 13:10
 **/
//@Aspect
public class MyAspect03 {

    @Pointcut("execution(* com.yr.springboot.demo02.service.User02ServiceImpl.printUser(..))")
    public void pointCut(){ }

    /**
     * @DeclareParents: 引入新的类来增强服务，有两个必须配置的属性：
     * value：指向你要增强功能的目标对象，这里是增强 UserServiceImpl 对象，则 value 的值为 com.yr.springboot.demo02.service.UserServiceImpl
     * defaultImpl：引入增强功能的类，“+”号表示这个类的子类。
     * UserServiceImpl后面不添加 “+” 号，在Springboot2 之后，“+”加号表示这个类的子类，不包括其本身
     */
    @DeclareParents(value = "com.yr.springboot.demo02..service.UserServiceImpl", defaultImpl = com.yr.springboot.demo02.service.UserValidatorImpl.class)
    public UserValidator userValidator;

    /**
     * 非环绕通知获取参数
     * 1. 在注解中添加：args(user)，表明传入的参数名称为 user。
     * 2. 在方法中利用 JoinPoint 传入对应的参数。与注解中的参数名称保持一致。
     */
    @Before("pointCut() && args(user)")
    public void before(JoinPoint point, User user) {
        System.out.println("在 Before 中获取参数");
        Object[] args = point.getArgs();
        for(Object arg: args) {
            System.out.println("user 中的参数：" + arg);
        }
        System.out.println("before...");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after...");
    }

    @Around("pointCut() && args(user)")
    public void around(ProceedingJoinPoint joinPoint, User user) throws Throwable {
        System.out.println("在 around 中获取参数");
        Object[] args = joinPoint.getArgs();
        for(Object arg: args) {
            System.out.println("在 around 中，user 的参数：" + arg);
        }

        joinPoint.proceed();

        System.out.println("around after...");
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
