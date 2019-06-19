package com.yazao.spring.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yazao.spring.User;
import com.yazao.spring.allannotation.SpringConfig;
import com.yazao.spring.annotation.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MyTest {

    @Test
    public void test1() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        user.run();

        User user2 = (User) context.getBean("user2");
        user2.run();
    }

    @Test
    public void test2() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //硬编码方式
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setDriverClass("com.mysql.jdbc.Driver");
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hibernate");
//        dataSource.setUser("root");
//        dataSource.setPassword("123");

        //采用 spring applicationContext_jdbc.xml 动态加载
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }


    @Test
    public void test3() {
        //半注解半xml

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());
    }

    @Test
    public void test4() throws SQLException {
        //全注解

        //加载注解类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());



        DataSource dataSource = (DataSource) context.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }


}
