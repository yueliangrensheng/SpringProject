package com.yazao.ssm.service.impl;

import com.yazao.ssm.domain.Items;
import com.yazao.ssm.domain.ItemsExample;
import com.yazao.ssm.domain.QueryVo;
import com.yazao.ssm.mapper.ItemsMapper;
import com.yazao.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    public ItemsMapper itemsMapper;

    @Override
    public List<Items> findAll() {
        return itemsMapper.selectByExampleWithBLOBs(new ItemsExample());
    }

    @Override
    public Items findById(int itemId) {
        return itemsMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public int update(Items item) {
        int index = itemsMapper.updateByPrimaryKeySelective(item);
        return index;
    }

    @Override
    public List<Items> findAll(QueryVo queryVo) {

            if (queryVo == null) {
            return findAll();
        }

        if (queryVo.getItems() == null) {
            return findAll();
        }

        if ("".equals(queryVo.getItems().getName()) && queryVo.getItems().getPrice() == null) {
            return findAll();
        } else {
            String name = queryVo.getItems().getName();
            Float price = queryVo.getItems().getPrice();
            Items items = null;

            if (!"".equals(name)) {
                items = itemsMapper.selectByName(name);
            }

            if (price != null) {
                items = itemsMapper.selectByPrice(price);
            }

            if (!"".equals(name) && price != null) {
                items = itemsMapper.selectByNameAndPrice(name, price);
            }

            List<Items> itemsList = new ArrayList<>();
            itemsList.add(items);
            return itemsList;
        }
    }
}
