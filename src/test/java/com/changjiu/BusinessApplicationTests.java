package com.changjiu;

import com.changjiu.bean.Business99Data;
import com.changjiu.servece.Business99Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BusinessApplicationTests {


    @Autowired
    private Business99Service business99Service;

    @Test
    void test1() {
        Business99Data business99Data = new Business99Data();
        business99Data.setName("asd");
        business99Service.save(business99Data);
    }




}
