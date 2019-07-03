package com.yazao.mybatis;

import com.yazao.mybatis.mapper.UserMapper;
import com.yazao.mybatis.pojo.QueryVo;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testFindUserById2() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map map = userMapper.findUserById2(29);
        System.out.println(map);
    }

    @Test
    public void testFindUserCount() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

       int count = userMapper.findUserCount();
        System.out.println(count);
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
    public void testFindUserByMap() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap();
        map.put("username","张");
        map.put("sex","1");
        map.put("address","北京市");

        List<User> userList = userMapper.findUserByMap(map);
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    public void testFindUserByQueryVo() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("张");
        queryVo.setUser(user);

        List<User> userList = userMapper.findUserByQueryVo(queryVo);
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
