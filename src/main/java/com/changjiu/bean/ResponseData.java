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

    //注释掉的写法不规范
    /*public ResponseData<T> success(CommonStateInfo commonStateInfo){
        return success(commonStateInfo,null);   //可以传null,因为泛型不能是基本数据类型,必须是引用类型
    }*/



   /* public ResponseData<T> success(CommonStateInfo commonStateInfo, T data){
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(commonStateInfo.getCode());
        responseData.setMsg(commonStateInfo.getMsg());
        responseData.setData(data);
        return responseData;
    }*/

    //注意：静态方法不能使用类的泛型，因此静态方法想要使用泛型，必须将静态方法定义为泛型方法
    //同时泛型方法的泛型标识T和类的泛型标识T不是同一个T,如第二个success方法用E来表示，E对于
    //类的泛型T来说，E是ResponseData<T>类的类泛型形参T的实参
    public static <T> ResponseData<T> success(CommonStateInfo commonStateInfo, T data) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(commonStateInfo.getCode());
        responseData.setMsg(commonStateInfo.getMsg());
        responseData.setData(data);
        return responseData;
    }

    public static <E> ResponseData<E> success(CommonStateInfo commonStateInfo) {
        return success(commonStateInfo, null);   //可以传null,因为泛型不能是基本数据类型,必须是引用类型
    }

    /*public ResponseData<T> error(CommonStateInfo exceptionInfo) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(exceptionInfo.getCode());
        responseData.setMsg(exceptionInfo.getMsg());
        return responseData;
    }

    public ResponseData<T> error(String code, String msg) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(code);
        responseData.setMsg(msg);
        return responseData;
    }*/

    public static <T> ResponseData<T> error(CommonStateInfo exceptionInfo) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(exceptionInfo.getCode());
        responseData.setMsg(exceptionInfo.getMsg());
        return responseData;
    }

    public static <T> ResponseData<T> error(String code, String msg) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(code);
        responseData.setMsg(msg);
        return responseData;
    }

}
