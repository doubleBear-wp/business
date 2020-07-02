package com.changjiu.dao.impl;

import com.changjiu.bean.Business99Data;
import com.changjiu.dao.JDBCDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author doubleBear
 * @create 2020 07 02 11:00
 */

@Repository("jdbcDao")
public class JDBCDaoImpl implements JDBCDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Business99Data business99Data) {
        String sql = "insert into business99_data(name) " +
                "values(?)";
        jdbcTemplate.update(sql,business99Data.getName());
    }
}
