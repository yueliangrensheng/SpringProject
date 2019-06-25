package com.yazao.ssm.service;

import com.yazao.ssm.domain.Items;
import com.yazao.ssm.domain.QueryVo;

import java.util.List;


public interface ItemService {

	public List<Items> findAll();

	public Items findById(int itemId);

	public int update(Items item);

	List<Items> findAll(QueryVo queryVo);
}
