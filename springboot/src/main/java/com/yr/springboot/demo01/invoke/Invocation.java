package com.yr.springboot.demo01.invoke;

import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 拦截器 interceptor 中，around 方法中，invocation 对象的源码。
 */
@Data
public class Invocation {
  private Object[] param;
  private Method method;
  private Object target;

  public Invocation(Object target,Method method,Object[] param){
    this.method=method;
    this.target=target;
    this.param=param;
  }

  /**
   * 反射方法。以反射的形式去调用原有的方法。
   */
  public Object proceed() throws InvocationTargetException,IllegalAccessException {
    System.out.println("调用 target 对象对应的方法。target：" + target + "method："+method);
    return method.invoke(target,param);
  }
}
