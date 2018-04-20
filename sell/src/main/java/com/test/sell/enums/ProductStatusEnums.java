package com.test.sell.enums;

public enum ProductStatusEnums {
    UP(0,"已经上架"),
    DOWN(1,"未上架出售")
    ;

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ProductStatusEnums(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
