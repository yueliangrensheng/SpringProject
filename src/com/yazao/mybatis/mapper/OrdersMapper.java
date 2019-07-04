package com.yazao.mybatis.mapper;

import com.yazao.mybatis.pojo.Orders;

import java.util.List;

public interface OrdersMapper {

    public List<Orders> findOrdersList();
}
