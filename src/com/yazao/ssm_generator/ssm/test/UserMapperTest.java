package com.yazao.ssm_generator.ssm.test;

import com.yazao.ssm_generator.ssm.mapper.UserMapper;
import com.yazao.ssm_generator.ssm.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");


        UserMapper userMapper = applicationContext.getBean(UserMapper.class);

        User user = userMapper.selectByPrimaryKey(29);

        System.out.println(user);
    }
}
