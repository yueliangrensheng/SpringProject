package com.yazao.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

//切面类
public class MyAspect {

    public void before(){
        System.out.println("------ 前置方法 ------");
    }

    public void afterReturning(){
        System.out.println("------ 后置方法（如果出现异常，不会走这个方法） ------");
    }

    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("------ 环绕方法 之前------");
        Object proceed = proceedingJoinPoint.proceed();//相当于是 手动 执行 原有的 方法
        System.out.println("------ 环绕方法 之后------");

    }

    public void throwMethod(){
        System.out.println("------ 异常方法 ------");
    }

    public void after(){
        System.out.println("------ 后置方法（即使出现异常，也会走这个方法） ------");
    }


}
