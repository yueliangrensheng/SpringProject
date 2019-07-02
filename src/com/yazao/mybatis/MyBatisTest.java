package com.yazao.mybatis;

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

public class MyBatisTest {

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

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.使用sqlSession的方法
        // selectOne方法中参数 s：userMapper.xml中的 statementId o：输入映射的参数
        User user = sqlSession.selectOne("findUserById", 10);
        System.out.println(user.toString());
        //4.关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testFindUserByUsername() throws IOException {

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.使用sqlSession的方法
        // selectOne方法中参数 s：userMapper.xml中的 statementId o：输入映射的参数
        List<User> userList = sqlSession.selectList("findUserByUsername", "张");
        System.out.println(userList.toString());
        sqlSession.close();
    }

    @Test
    public void testAddUser() throws IOException {

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.使用sqlSession的方法
        User user = new User();
        user.setId(0);
        user.setSex("1");
        user.setAddress("yuncheng");
        user.setBirthday(new Date());
        user.setUsername("moonlife");
        sqlSession.insert("addUser", user);
        sqlSession.commit();
        System.out.println(user);
        sqlSession.close();

    }


    @Test
    public void testUpdateUserById() throws IOException {

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.使用sqlSession的方法
        User user = new User();
        user.setId(29);
        user.setSex("2");
        user.setAddress("yuncheng");
        user.setBirthday(new Date());
        user.setUsername("moonlife");
        sqlSession.update("updateUserById", user);
        sqlSession.commit();
        System.out.println(user);
        sqlSession.close();

    }

    @Test
    public void testDeleteUserById() throws IOException {

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.使用sqlSession的方法
        sqlSession.delete("deleteUserById", 28);
        sqlSession.commit();
        sqlSession.close();

    }


}
