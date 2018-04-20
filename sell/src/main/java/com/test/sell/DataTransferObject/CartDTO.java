package com.test.sell.DataTransferObject;

import lombok.Data;

/**
 * @file_name: 购物车
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/17 15:49
 * @version：
 */
@Data
public class CartDTO {
    /** 商品id
     *
     */
    private String productId;

    /* 商品数量
     */
    private long productQuantity;

    public CartDTO(String productId, long productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}
