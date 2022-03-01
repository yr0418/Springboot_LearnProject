package com.yr.springboot.demo01.intercept;

import com.yr.springboot.demo01.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @description: 定义一个拦截器
 */

public interface Interceptor {
  /**
   * 事前方法
   */
  public boolean before();

  /**
   * 事后方法
   */
  public void after();

  /**
   * 取代原有事件，
   * @param invocation：回调参数，通过 proceed 方法，回调原有事件
   * @return 原有事件返回对象
   * @throws InvocationTargetException
   * @throws IllegalAccessException
   */
  public Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException;

  /**
   * 事后返回方法，事件没有发生异常时执行
   */
  public void afterReturning();

  /**
   * 事后异常方法，事件发生异常后执行
   */
  public void afterThrowing();

  /**
   * 是否使用 around 方法 替代原有方法
   */
  boolean userAround();
}
