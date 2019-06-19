package com.yazao.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component(value = "person") //相当于在 applicationContext.xml中 配置：<bean id="person" class="com.yazao.spring.annotation.Person"></bean>
public class Person {
    @Value(value = "moonlife") //相当于  name = "moonlife"；
    private String name;
    @Value(value = "20")
    private int age;

    @Autowired(required = false) //默认是true，如果是false，辣么表示：这个类 action 可以不需要 被 @Component 注解
    @Qualifier(value = "action") //指定使用该类型的哪个名称的实例对象
    private Action action;

    @PostConstruct
    public void init(){
        System.out.println("Person init-----------");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Person destroy ---------");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", action=" + action +
                '}';
    }
}
