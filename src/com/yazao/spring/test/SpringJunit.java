package com.yazao.spring.test;

import com.yazao.spring.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//1。加载applicationContext.xml文件
@ContextConfiguration(value = "classpath:applicationContext.xml")
//2。使用 SpringJUnit4ClassRunner 来单元测试
@RunWith(value = SpringJUnit4ClassRunner.class)
public class SpringJunit {

    @Autowired
    private User user;
    @Autowired
    private User user2;

    @Test
    public void test1(){
        user.run();
        user2.run();
    }

}
