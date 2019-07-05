package com.yazao.mybatis_spring.proxy;

import com.yazao.mybatis_spring.mapper.UserMapper;
import com.yazao.mybatis_spring.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        UserMapper mapper = applicationContext.getBean(UserMapper.class);

        User user = mapper.findUserById(29);

        System.out.println(user);
    }
}
