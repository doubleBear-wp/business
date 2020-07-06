package com.changjiu.exception;

/**
 * @author doubleBear
 * @create 2020 07 06 9:59
 */
public class DataIsEmpty extends RuntimeException {
    public DataIsEmpty() {
    }

    public DataIsEmpty(String message){
        super(message);
    }
}
