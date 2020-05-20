package cn.yu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("cn.yu")

/**
 * proxyTargetClass 默认其概况下使用JDK代理
 * JDK代理时，指向接口和代理类proxy
 *
 * proxyTargetClass = true
 * 使用cglib代理时 指向接口和子类(不使用proxy)
 */
@EnableAspectJAutoProxy(proxyTargetClass = true) //启用@AspectJ支持
public class AppConfig {
}
