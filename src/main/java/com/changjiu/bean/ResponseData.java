package com.changjiu.bean;

import com.changjiu.exception.CommonStateInfo;

/**
 * @author doubleBear
 * @create 2020 07 06 14:49
 */
public class ResponseData<T> {
    private String code;
    private String msg;
    //泛型不能用static修饰，因为泛型正是因为构建类的时候不确定采用泛型代替，而
    //static要求在类加载的时候就确定，显然是矛盾点
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public ResponseData<T> success(CommonStateInfo commonStateInfo){
        return success(commonStateInfo,null);   //可以传null,因为泛型不能是基本数据类型,必须是引用类型
    }

    public ResponseData<T> success(CommonStateInfo commonStateInfo, T data){
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(commonStateInfo.getCode());
        responseData.setMsg(commonStateInfo.getMsg());
        responseData.setData(data);
        return responseData;
    }

    public ResponseData<T> error(CommonStateInfo exceptionInfo){
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(exceptionInfo.getCode());
        responseData.setMsg(exceptionInfo.getMsg());
        return responseData;
    }

    public ResponseData<T> error(String code, String msg){
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(code);
        responseData.setMsg(msg);
        return responseData;
    }

}
