package com.test.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @file_name: OrderForm
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/20 16:20
 * @version：
 */
@Data
public class OrderForm {
    /*
    买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信id
     */
    @NotEmpty(message = "opedid必填")
    private String opednid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}