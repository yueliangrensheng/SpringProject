package com.yazao.mybatis_spring.tradition.dao;

import com.yazao.mybatis_spring.pojo.User;

public interface UserDao {

    public User findUserByid(int id);

    public void insertUser(User user);
}
