package com.changjiu.exception;

/**
 * @author doubleBear
 * @create 2020 07 06 10:54
 */
public class DataIsEmpty extends RuntimeException {
    public DataIsEmpty(){}

    public DataIsEmpty(String message){
        super(message);
    }
}
