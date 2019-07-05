package com.yazao.mybatis_spring.mapper;

import com.yazao.mybatis_spring.pojo.User;

public interface UserMapper {

    public User findUserById(int id);

    public void insertUser(User user);
}
