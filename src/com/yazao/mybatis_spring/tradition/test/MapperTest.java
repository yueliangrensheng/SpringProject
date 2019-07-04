package com.yazao.mybatis_spring.tradition.test;

import com.yazao.mybatis_spring.pojo.User;
import com.yazao.mybatis_spring.tradition.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MapperTest {

    public static void main(String[] args) {
        // 1。 加载spring 容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //2.获取userDao对象
        UserDao userDao = applicationContext.getBean(UserDao.class);

        User user = userDao.findUserByid(29);
        System.out.println(user);


        User newUser = new User();
        newUser.setId(40);
        newUser.setUsername("moon");
        newUser.setAddress("bj");
        newUser.setBirthday(new Date());
        newUser.setSex("2");
        userDao.insertUser(newUser);

        System.out.println(newUser);
    }
}
