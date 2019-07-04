package com.yazao.mybatis;

import com.yazao.mybatis.mapper.OrdersMapper;
import com.yazao.mybatis.pojo.Orders;
import com.yazao.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrdersTest {
    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        sqlSessionFactory = builder.build(inputStream);

    }

    @Test
    public void testFindOrdersList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);

        List<Orders> ordersList = mapper.findOrdersList();
        System.out.println(ordersList);
    }
    @Test
    public void testFindUserList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);

        List<User> userList = mapper.findUserList();
        System.out.println(userList);
    }
}
