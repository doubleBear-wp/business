package com.changjiu.controller;

import com.changjiu.bean.Business99;
import com.changjiu.bean.ResponseData;
import com.changjiu.exception.CommonStateInfoEnum;
import com.changjiu.exception.customized.DataIsEmptyException;
import com.changjiu.service.Business99Service;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author doubleBear
 * @create 2020 07 06 12:43
 */
@RestController
public class Business99Controller {

    @Autowired
    private Business99Service business99Service;

    @GetMapping("/add")
    public ResponseData<Business99> addBusiness99Data(String brand, String carSeries, String carType,
                                          String region, Double price, String createTime){
        Business99 business99 = new Business99();
        business99.setBrand(brand);
        business99.setCarSeries(carSeries);
        business99.setCarType(carType);
        business99.setRegion(region);
        business99.setPrice(price);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(createTime != null){

                Date date = format.parse(createTime);
                System.out.println(date);
                business99.setCreateTime(date);
                business99.setUpdateTime(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        List<Business99> dataList = new ArrayList();
        dataList.add(business99);
        ResponseData<Business99> responseData = new ResponseData<>();
        try {
            business99Service.saveAll(dataList);
            responseData.setCode("1");
            responseData.setMsg("提交数据成功！");
        } catch (DataIsEmptyException e) {
            responseData.setCode("0");
            responseData.setMsg(e.getMessage());
        }
        responseData.setData(business99);
        return responseData;
    }

    @PostMapping("/add")
    public ResponseData<List<Business99>> addBusiness99(@RequestBody List<Business99> dataList){
        ResponseData<List<Business99>> responseData = new ResponseData<>();
        //如下方法可能发生异常，用更加优雅的全局异常处理器来处理
        business99Service.saveAll(dataList);
        return responseData.success(CommonStateInfoEnum.INSERT_DATA_SUCCESS,dataList);
    }

    @GetMapping("/test")
    public ResponseData<Null> test(){
        String str = "abc";
        str = null;
        str.toString();
        return new ResponseData<Null>().success(CommonStateInfoEnum.SUCCESS);
    }
}
