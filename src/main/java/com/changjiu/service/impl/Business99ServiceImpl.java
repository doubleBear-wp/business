package com.changjiu.service.impl;

import com.changjiu.bean.Business99;
import com.changjiu.bean.Business99Data;
import com.changjiu.dao.Business99Dao;
import com.changjiu.exception.CommonStateInfoEnum;
import com.changjiu.exception.customized.DataIsEmptyException;
import com.changjiu.service.Business99Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void saveAll(List<Business99> dataList) {
        int size = dataList.size();
        if(size == 0){
            throw new DataIsEmptyException(CommonStateInfoEnum.DATA_IS_EMPTY);
        }

        if(size < 100){
            business99Dao.insertAll(dataList);
        }else{
            List<Business99> tempList = new ArrayList<>(101);
            for (int i = 0; i < size; i++) {
                tempList.add(dataList.get(i));
                if(i != 0 && i % 100 == 0){
                    business99Dao.insertAll(tempList);
                    tempList = new ArrayList<>(101);
                }
            }
            if(tempList.size() != 0){
                business99Dao.insertAll(tempList);
            }
        }
    }

/*@Autowired
    private JDBCDao jdbcDao;

    @Override
    public void save(Business99Data business99Data) {
        jdbcDao.insert(business99Data);
    }*/

}
