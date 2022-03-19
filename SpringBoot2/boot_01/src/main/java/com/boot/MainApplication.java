package com.boot;

import com.boot.bean.Pet;
import com.boot.bean.User;
import com.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author wanyu
 * @createTime 2022-03-19 22:52
 * * 主程序类
 * * @SpringBootApplication：这是一个SpringBoot应用
 */
@SpringBootApplication(scanBasePackages = "com.boot")
public class MainApplication {
    public static void main(String[] args) {
        //1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            //System.out.println(name);
        }

        //3、从容器中获取组件
        Pet tom1 = run.getBean("tom", Pet.class);
        Pet tom2 = run.getBean("tom", Pet.class);
        System.out.println("组件：" + (tom1 == tom2));

        //4、com.boot.config.MyConfig$$EnhancerBySpringCGLIB$$51f1e1ca@1654a892
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        //保持组件单实例
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user == user1);

    }
}
