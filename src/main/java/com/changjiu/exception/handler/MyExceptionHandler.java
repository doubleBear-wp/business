package com.changjiu.exception.handler;

import com.changjiu.bean.ResponseData;
import com.changjiu.exception.CommonStateInfoEnum;
import com.changjiu.exception.customized.DataIsEmptyException;
import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @author doubleBear
 * @create 2020 07 08 9:15
 */

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(DataIsEmptyException.class)
    @ResponseBody
    public ResponseData<Null> DataIsEmptyExceptionHandler(DataIsEmptyException e){
//        Logger logger = Logger.getLogger(MyExceptionHandler.class);
//        logger.
        System.out.println(e.getMessage());
        return new ResponseData<Null>().error(e.getErrorCode(),e.getErrorMsg());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseData<Null> ExceptionHandler(Exception e){
        System.out.println(e.getMessage());
        return new ResponseData<Null>().error(CommonStateInfoEnum.INTERNAL_SERVER_ERROR);
    }
}
