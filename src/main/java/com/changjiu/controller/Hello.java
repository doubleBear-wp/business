package com.changjiu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author doubleBear
 * @create 2020 07 01 16:30
 */
@RestController
public class Hello {

    @RequestMapping("/hello")
    public String m1(){
        return "hello";
    }

}
