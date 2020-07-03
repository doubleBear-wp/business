package com.changjiu.servece;

import com.changjiu.bean.Business99;
import com.changjiu.bean.Business99Data;

import java.util.List;

/**
 * @author doubleBear
 * @create 2020 07 01 15:40
 */
public interface Business99Service {

    void save(Business99Data business99Data);

    void saveAll(List<Business99> dataList);
}
