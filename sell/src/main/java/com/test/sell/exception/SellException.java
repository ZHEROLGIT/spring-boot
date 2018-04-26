package com.test.sell.exception;

import com.test.sell.enums.ResultEnums;

/**
 * @file_name: SellException
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/17 14:58
 * @version：
 */
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnums resultEnums) {
        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();
    }

    public SellException(Integer code,String message){
        super(message);
        this.code = code;
    }
}
