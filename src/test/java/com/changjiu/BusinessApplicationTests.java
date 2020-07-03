package com.changjiu;

import com.changjiu.bean.Business99;
import com.changjiu.bean.Business99Data;
import com.changjiu.dao.Business99Dao;
import com.changjiu.servece.Business99Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest
class BusinessApplicationTests {


    @Autowired
    private Business99Service business99Service;

    @Test
    void test1() {
        Business99Data business99Data = new Business99Data();
        business99Data.setName("test");
        business99Service.save(business99Data);
    }

    @Autowired
    private DataSource dataSource;

    @Test
    public void test2() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void test3() {
        Business99 b1 = new Business99();
        b1.setBrand("海马");
        b1.setCarSeries("福美来");
        b1.setCarType("福美来三代");
        b1.setRegion("北京");
        b1.setPrice(10000.10);
        Date date = new Date();
        b1.setCreateTime(date);
        b1.setUpdateTime(date);

        Business99 b2 = new Business99();
        b2.setBrand("大众");
        b2.setCarSeries("帕萨特");
        b2.setCarType("帕萨特");
        b2.setRegion("上海");
        b2.setPrice(14000.00);
        b2.setCreateTime(date);
        b2.setUpdateTime(date);

        List<Business99> dataList = new ArrayList();
        dataList.add(b1);
        dataList.add(b2);

        business99Service.saveAll(dataList);

    }

    @Test
    public void test4() {
        Business99 b1 = new Business99();
//        b1.setBrand("东风风度");
//        b1.setCarSeries("奥丁");
//        b1.setCarType("奥丁");
//        b1.setRegion("山东");
        b1.setPrice(10400.10);
        Date date = new Date();
        b1.setCreateTime(date);
        b1.setUpdateTime(date);

        List<Business99> dataList = new ArrayList();
        dataList.add(b1);
        business99Service.saveAll(dataList);
    }

    @Autowired
    private Business99Dao business99Dao;


    @Test
    public void test5(){
        Business99 business99 = business99Dao.selectById(1);
        System.out.println(business99);
    }

    @Test
    public void test6(){
        System.out.println(1);
        System.out.println("你不拉我试试能推上来不？");
    }

}
