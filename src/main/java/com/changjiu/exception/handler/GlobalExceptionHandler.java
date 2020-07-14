package com.changjiu.exception.handler;

import com.changjiu.bean.ResponseData;
import com.changjiu.exception.CommonStateInfoEnum;
import com.changjiu.exception.customized.DataIsEmptyException;
import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @author doubleBear
 * @create 2020 07 08 9:15
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DataIsEmptyException.class)
    @ResponseBody
    public ResponseData<Null> DataIsEmptyExceptionHandler(DataIsEmptyException e){
        logger.error("业务异常："+e.getMessage());
        //<Null>可以省略，因为此处使用了类型推断
        return ResponseData.<Null>error(e.getErrorCode(),e.getErrorMsg());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseData<Null> ExceptionHandler(Exception e){
        logger.error("未知异常："+e);

        ResponseData error = ResponseData.<Null>error(CommonStateInfoEnum.INTERNAL_SERVER_ERROR);
        //上下两种方式都可以为泛型方法指明具体的泛型实参，上面是调用泛型方法指明，下面是采用类型推断
//        ResponseData<Null> error = ResponseData.error(CommonStateInfoEnum.INTERNAL_SERVER_ERROR);
        return error;
    }
}
