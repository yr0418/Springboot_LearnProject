package com.yr.springboot.demo01.intercept;

import com.yr.springboot.demo01.intercept.Interceptor;
import com.yr.springboot.demo01.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @description: 基于 interceptor 自定义一个拦截器。
 * 拦截器中方法的执行流程，在代理对象 ProxyBean 的 invoke 方法中被定义
 */
public class MyInterceptor implements Interceptor {

  /**
   * 调用方法时，会先执行拦截器中的 before 方法。
   */
  @Override
  public boolean before() {
    System.out.println("事前方法，before...");
    return true;
  }

  /**
   * 方法调用执行完成后，会执行拦截器中的 after 方法。
   */
  @Override
  public void after() {
    System.out.println("事后方法，after...");
  }

  @Override
  public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
    System.out.println("around before....");

    // proceed 方法，可回调 target对象 对应的方法。
    Object object = invocation.proceed();
    System.out.println("around after....");
    return object;
  }

  /**
   * 在 after 方法执行完后，若执行 around 方法或者回调 target 方法时，未发生异常，则执行该方法。
   */
  @Override
  public void afterReturning() {
    System.out.println("afterReturning...");
  }

  /**
   * 在 after 方法执行完后，若执行 around 方法或者回调 target 方法时，发生异常，则执行该方法。
   */
  @Override
  public void afterThrowing() {
    System.out.println("afterThrowing....");
  }

  /**
   * 若 useAround 方法返回 true，则方法在调用时，会执行拦截器的 around 方法。若返回 false，则执行原方法。
   */
  @Override
  public boolean userAround() {
    return true;
  }
}
