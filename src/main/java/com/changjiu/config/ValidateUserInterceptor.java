package com.changjiu.config;

import com.changjiu.util.Token;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author doubleBear
 * @create 2020 07 14 12:23
 */

@Component
public class ValidateUserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String appid = request.getParameter("appid");
        String time = request.getParameter("time");
        String info = request.getParameter("info");
        String sign = request.getParameter("sign");

        return Token.validate(appid,time,info,sign);
    }
}
