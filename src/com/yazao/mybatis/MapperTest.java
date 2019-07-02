package com.yazao.mybatis;

import com.yazao.mybatis.mapper.UserMapper;
import com.yazao.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MapperTest {
    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws IOException {
        // 1. 获取sqlSessionFactory对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        sqlSessionFactory = builder.build(resourceAsStream);
    }


    @Test
    public void testFindUserById() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(29);
        System.out.println(user);
    }

    @Test
    public void testFindUserByUsername() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findUserByUsername("张");
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    public void testAddUser() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(0);
        user.setSex("1");
        user.setAddress("yuncheng");
        user.setBirthday(new Date());
        user.setUsername("yueliangrensheng");

        userMapper.addUser(user);
        sqlSession.commit();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testUpdateUserById() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(37);
        user.setSex("1");
        user.setAddress("yuncheng");
        user.setBirthday(new Date());
        user.setUsername("yueliangrensheng");

        userMapper.updateUserById(user);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUserById() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.deleteUserById(38);
        sqlSession.commit();
        sqlSession.close();
    }

}
