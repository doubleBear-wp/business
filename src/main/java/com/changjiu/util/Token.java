package com.changjiu.util;

import org.springframework.util.DigestUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author doubleBear
 * @create 2020 07 13 17:05
 */
public class Token {

    //用户拥有的接口
    private static List<String> appids;
    //私钥
    private static String secret;
    //系统时间
    private static long time;

    //用静态代码块初始化及静态数据
    static {
        appids = Arrays.asList(new String[]{"1","2","3"});
        secret = "0c8466f9d12f45c38a5c4b32297799a4";
    }

    //初始化一个系统时间
    private static void init(){
        time = System.currentTimeMillis();
    }

    /**
     * 客户端使用这个方法得到一个数字签名
     * @param appid
     * @param time
     * @param secret
     * @param info
     * @return
     */
    public static String getSign(String appid, String time,  String info, String secret){
        StringBuffer buffer = new StringBuffer();
        buffer.append(appid);
        buffer.append(time);
        buffer.append(info);
        buffer.append(secret);

        String sign = DigestUtils.md5DigestAsHex(buffer.toString().getBytes());

        return sign;
    }


    /**
     * 服务端通过这个方法对用户进行合法性校验
     * @param appid
     * @param time
     * @param info
     * @param sign
     * @return
     */
    public static boolean validate(String appid, String time, String info, String sign){
        StringBuffer buffer = new StringBuffer();
        buffer.append(appid);
        buffer.append(time);
        buffer.append(info);
        buffer.append(secret);

        String _sign = DigestUtils.md5DigestAsHex(buffer.toString().getBytes());

        if(!_sign.equals(sign)){
            return false;
        }

        init();
        long _time = Long.parseLong(time);
        //超过10分钟失效
        if((Token.time - _time) > 10 * 60 * 1000){
            return false;
        }

        //判断用户是否拥有该接口，使用contains()方法的对象需要重写equals()方法，看源码contains()通过调用indexOf()方法，indexOf()方法调用equals();
        if(appids != null && !appids.contains(appid)){
            return false;
        }

        return true;
    }

}
