package com.changjiu.exception.customized;

import com.changjiu.exception.CommonStateInfo;

/**
 * @author doubleBear
 * @create 2020 07 06 10:54
 */
public class DataIsEmptyException extends RuntimeException {
    private String errorCode;
    private String errorMsg;

    public DataIsEmptyException(){}

    public DataIsEmptyException(CommonStateInfo commonStateInfo){
        super(commonStateInfo.getMsg());
        errorCode = commonStateInfo.getCode();
        errorMsg = commonStateInfo.getMsg();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "DataIsEmptyException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
