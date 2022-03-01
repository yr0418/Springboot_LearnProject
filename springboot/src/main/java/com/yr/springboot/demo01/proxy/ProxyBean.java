package com.yr.springboot.demo01.proxy;

import com.yr.springboot.demo01.intercept.Interceptor;
import com.yr.springboot.demo01.invoke.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 代理对象，对真实对象进行代理，以便于将服务类和拦截方法织入对应的流程。
 */
public class ProxyBean implements InvocationHandler {
  private Object target;
  private Interceptor interceptor = null;

  /**
   * 绑定 代理对象
   * @param target —— 被代理的对象
   * @param interceptor —— interceptor 拦截器
   * @return 代理对象
   */
  public static Object getProxyBean(Object target, Interceptor interceptor){
    ProxyBean proxyBean=new ProxyBean();

    //保存被代理的对象
    proxyBean.target=target;

    //保存拦截器
    proxyBean.interceptor=interceptor;

    //生成代理对象
    Object proxy= Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);

    return proxy;
  }

  /**
   * 处理代理对象 的方法逻辑
   * @param proxy —— 代理对象
   * @param method —— 当前方法
   * @param args —— 运行参数
   * @return 方法调用结果
   * @throws Throwable 异常
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //异常标识
    boolean exceptionFlag = false;

    Invocation invocation = new Invocation(target,method,args);

    Object object = null;

    // 执行拦截器中的 before 方法
    this.interceptor.before();

    try {
      // 如果 userAround 方法返回 true，则执行拦截器中的 around 方法，否则，执行 target对象 对应的方法。
      if (this.interceptor.userAround()) {
        object = this.interceptor.around(invocation);
      }
      else {
        object = method.invoke(target,args);
      }
    }
    catch (Exception e) {
      exceptionFlag = true;
    }

    // 执行拦截器中的 after 方法。
    this.interceptor.after();

    // 针对是否产生异常，执行拦截器中对应的方法。
    if (exceptionFlag) {
      this.interceptor.afterThrowing();
    }
    else {
      this.interceptor.afterReturning();
      return object;
    }
    return null;
  }
}
