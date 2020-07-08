package com.changjiu.exception;

/**
 * @author doubleBear
 * @create 2020 07 07 17:08
 */
public enum CommonStateInfoEnum implements CommonStateInfo {
    SUCCESS("200", "成功!"),
    DATA_IS_EMPTY("0","插入数据为空！"),
    INSERT_DATA_SUCCESS("1","插入数据成功"),
    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401","请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!");

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    private String code;
    private String msg;

    CommonStateInfoEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
