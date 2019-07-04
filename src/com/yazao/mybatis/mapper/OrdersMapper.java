package com.yazao.mybatis.mapper;

import com.yazao.mybatis.pojo.Orders;
import com.yazao.mybatis.pojo.User;

import java.util.List;

public interface OrdersMapper {

    public List<Orders> findOrdersList();

    public List<User> findUserList();
}
