package com.yr.springboot.demo02.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAspect02 {
  /**
   * 定义切点，设置正则表达式，注明什么方法才启用 AOP
   */
  @Pointcut("execution(* com.yr.springboot.demo02.service.User02ServiceImpl.printUser(..))")
  public void pointCut(){ }

  @Before("pointCut()")
  public void before(){
    System.out.println("MyAspect02 before....");
  }

  @After("pointCut()")
  public void after(){
    System.out.println("MyAspect02 after....");
  }

  @AfterReturning("pointCut()")
  public void afterReturning(){
    System.out.println("MyAspect02 afterReturning....");
  }

  @AfterThrowing("pointCut()")
  public void afterThrowing(){
    System.out.println("MyAspect02 afterThrowing....");
  }

  @Around("pointCut()")
  public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    System.out.println("MyAspect02 around before....");
    System.out.println("MyAspect02 around test...");

    // 利用 proceedingJoinPoint 回调目标对象原有方法
    proceedingJoinPoint.proceed();

    // 取代原有目标对象方法的通知
    System.out.println("MyAspect02 使用环绕通知");
    System.out.println("MyAspect02 around after....");
  }
}
