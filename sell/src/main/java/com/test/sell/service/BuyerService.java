package com.test.sell.service;

import com.test.sell.DataTransferObject.OrderDTO;
import org.springframework.util.StringUtils;

/**
 * 买家
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
