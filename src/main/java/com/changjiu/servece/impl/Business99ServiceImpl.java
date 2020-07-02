package com.changjiu.servece.impl;

import com.changjiu.bean.Business99Data;
import com.changjiu.dao.Business99Dao;
import com.changjiu.dao.JDBCDao;
import com.changjiu.servece.Business99Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author doubleBear
 * @create 2020 07 01 15:38
 */

@Service("business99Service")
public class Business99ServiceImpl implements Business99Service {

    @Autowired
    private Business99Dao business99Dao;

    @Override
    public void save(Business99Data business99Data) {
        business99Dao.insert(business99Data);
    }


    /*@Autowired
    private JDBCDao jdbcDao;

    @Override
    public void save(Business99Data business99Data) {
        jdbcDao.insert(business99Data);
    }*/

}
