package com.changjiu.dao;

import com.changjiu.bean.Business99;
import com.changjiu.bean.Business99Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author doubleBear
 * @create 2020 07 01 15:59
 */

@Mapper
public interface Business99Dao {
    void insert(Business99Data business99Data);

    void insertAll(@Param("dataList") List<Business99> dataList);

    Business99 selectById(int id);
}
