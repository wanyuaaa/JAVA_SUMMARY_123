package com.test.Proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author wanyu
 * @createTime 2022-03-13 16:14
 */
//增强类
//增强类优先级
@Component
@Aspect
@Order(0)//max
public class UserDaoProxyAnno {

    //相同切入点抽取
    @Pointcut(value = "execution(* com.test.dao.impl.UserDaoImpl.add(..))")
    public void pointDemo(){}

    //前置通知
    @Before(value = "pointDemo()")
    public void before() {
        System.out.println("before......");
    }

    //后置通知（返回通知）
    @AfterReturning(value = "pointDemo()")
    public void afterReturning() {
        System.out.println("afterReturning.........");
    }

    //最终通知
    @After(value = "pointDemo()")
    public void after() {
        System.out.println("after.........");
    }

    //异常通知
    @AfterThrowing(value = "pointDemo()")
    public void afterThrowing() {
        System.out.println("afterThrowing.........");
    }

    //环绕通知
    @Around(value = "pointDemo()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.........");
        //被增强的方法执行
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕之后.........");
        return proceed;
    }
}
