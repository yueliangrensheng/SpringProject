package com.yazao.ssm.service;

import com.yazao.ssm.domain.Items;
import com.yazao.ssm.domain.QueryVo;

import java.util.List;


public interface ItemService {

    public List<Items> findAll() throws Exception;

    public Items findById(int itemId) throws Exception;

    public int update(Items item) throws Exception;

    List<Items> findAll(QueryVo queryVo) throws Exception;
}
