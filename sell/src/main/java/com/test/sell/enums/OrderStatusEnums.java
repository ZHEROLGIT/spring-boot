package com.test.sell.enums;

public enum OrderStatusEnums {
    NEW(0,"新订单"),
    FINISH(1,"完结"),
    CANCLE(2,"已取消"),
    ;
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    OrderStatusEnums(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
