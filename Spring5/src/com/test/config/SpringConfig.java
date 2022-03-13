package com.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wanyu
 * @createTime 2022-03-13 14:31
 */
//创建配置类，替代 xml 配置文件
@Configuration
@ComponentScan(basePackages = "com.test")
public class SpringConfig {
}
