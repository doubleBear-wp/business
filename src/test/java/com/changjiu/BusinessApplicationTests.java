package com.changjiu;

import com.changjiu.bean.Business99;
import com.changjiu.bean.Business99Data;
import com.changjiu.dao.Business99Dao;
import com.changjiu.exception.customized.DataIsEmptyException;
import com.changjiu.service.Business99Service;
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
        b1.setBrand("东风");
        b1.setCarSeries("奥丁");
        b1.setCarType("奥丁");
        b1.setRegion("山东");
        b1.setPrice(10400.10);
        Date date = new Date();
        System.out.println(date);
        b1.setCreateTime(date);
        b1.setUpdateTime(date);

        List<Business99> dataList = new ArrayList();
        /*for (int i = 0; i < 10000; i++) {
        }*/
//        dataList.add(b1);

        try {
            business99Service.saveAll(dataList);
        } catch (DataIsEmptyException e) {
            System.out.println(e.getMessage());
        }
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
        m1(Date.class);
//        m2("java.util.Date");   //如果是Person类，m2()无法实现m1()的功能
    }

    /*
     *使用java反射，程序运行时通过类加载器加载一个类，通过反射API动态获取类结构信息，具有动态性
     * 也就是说不通过反射，常规java代码无法实现的功能，因为常规java代码都是程序未运行时，已经确定的情况，
     * 对于只有运行时才能决定的情况，常规java代码无法实现，如m2(String classPath)无法实现创建一个不确定
     * 类的对象，以至于不能获取类结构。此时借助java反射的动态性，就可以动态获取运行时类的信息，这就是java反射，
     * java反射的重要特征就是动态性，动态性体现在运行时获取类信息
     */
    public void m1(Class clazz){
        try {
            Object o = clazz.newInstance();
            System.out.println(o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /*
     *不使用反射，创建一个未知类的对象，需要枚举，但是无法全部枚举，
     * 因此这种做法是不能实现获取具体一个类的结构，不具有动态性
     */
    public void m2(String classPath){
        if(classPath == "java.util.Date"){
            new Date();
        }

        if(classPath == "java.lang.Object"){
            new Object();
        }

//        if(...)
//        ...

    }




}
