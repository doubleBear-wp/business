package com.changjiu.dao;

import com.changjiu.bean.Business99Data;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author doubleBear
 * @create 2020 07 01 15:59
 */

@Mapper
public interface Business99Dao {
    void insert(Business99Data business99Data);
}
