package com.changjiu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author doubleBear
 * @create 2020 07 14 11:24
 */

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private ValidateUserInterceptor validateUserInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器中/*匹配一级，即 /add , /query 等，不含子文件夹；/** ： 匹配多级，即 /add , /add/user, /add/user/user… 等
        registry.addInterceptor(validateUserInterceptor).addPathPatterns("/**");
    }
}
