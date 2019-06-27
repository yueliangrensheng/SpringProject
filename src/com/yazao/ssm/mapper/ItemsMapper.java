package com.yazao.ssm.mapper;

import java.util.List;

import com.yazao.ssm.domain.Items;
import com.yazao.ssm.domain.ItemsExample;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapper {
    int countByExample(ItemsExample example) throws Exception;

    int deleteByExample(ItemsExample example) throws Exception;

    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(Items record) throws Exception;

    int insertSelective(Items record) throws Exception;

    List<Items> selectByExampleWithBLOBs(ItemsExample example) throws Exception;

    List<Items> selectByExample(ItemsExample example) throws Exception;

    Items selectByPrimaryKey(Integer id) throws Exception;

    int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example) throws Exception;

    int updateByExampleWithBLOBs(@Param("record") Items record, @Param("example") ItemsExample example) throws Exception;

    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example) throws Exception;

    int updateByPrimaryKeySelective(Items record) throws Exception;

    int updateByPrimaryKeyWithBLOBs(Items record) throws Exception;

    int updateByPrimaryKey(Items record) throws Exception;

    Items selectByName(String name) throws Exception;

    Items selectByPrice(Float price) throws Exception;

    Items selectByNameAndPrice(@Param("name") String name, @Param("price") Float price) throws Exception;
}