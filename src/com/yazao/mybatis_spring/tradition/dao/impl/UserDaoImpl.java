package com.yazao.mybatis_spring.tradition.dao.impl;

import com.yazao.mybatis_spring.pojo.User;
import com.yazao.mybatis_spring.tradition.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

//    SqlSessionFactory sqlSessionFactory = null;
//
//    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
//        this.sqlSessionFactory = sqlSessionFactory;
//    }

    /**
     *
     *  UserDaoImpl 继承 SqlSessionDaoSupport 父类后，sqlSession = this.getSqlSession();
     *
     *  sqlSession 现在是由spring 容器来管理
     */

    @Override
    public User findUserByid(int id) {
        SqlSession sqlSession = /*sqlSessionFactory.openSession(); */ getSqlSession();
        User user = sqlSession.selectOne("test.findUserById", id);
        /*sqlSession.close(); */ //spring容器来管理
        return user;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = /*sqlSessionFactory.openSession(); */ getSqlSession();
        sqlSession.insert("test.insertUser", user);
        /*sqlSession.commit(); */ //spring容器来管理
        /*sqlSession.close(); */ //spring容器来管理
    }
}
