package com.changjiu.exception;

/**
 * @author doubleBear
 * @create 2020 07 07 17:08
 * CommonStateInfoEnum 枚举了各种常见状态（成功/失败）信息
 *
 * CommonStateInfo是一个接口，CommonStateInfoEnum实现了该接口
 *
 * DataIsEmptyException是自定义异常，通过CommonStateInfo接口依赖CommonStateInfoEnum的状态信息
 *
 * ResponseData定义了@ResponseBody对应的数据，该类有success和error方法，success可以通过CommonStateInfo接口依赖CommonStateInfoEnum的成功状态信息,
 * error可以通过传入自定义异常来获取异常信息，在未知异常时，也可通过CommonStateInfo接口依赖CommonStateInfoEnum的未知异常状态信息
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
