package com.yr.springboot.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @ComponentScan:当以该类为参数自定义 IOC 容器时，将会开启扫描，但只会扫描该类所在的包及其子包
 * 该注解允许我们自定义要扫描的包。
 * 示例如下：
 * 1.@ComponentScan(basePackages = "com.yr.springboot.Demo02.service.pojo")：扫描指定的包及其以下的子包
 * 2.@ComponentScan(basePackageClasses = {User.class}):扫描指定类
 */

@Configuration
//@ComponentScan(basePackages = "com.yr.springboot.demo02")
public class AppConfig {

}
