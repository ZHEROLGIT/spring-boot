package com.test.sell.service;

import com.test.sell.DataTransferObject.OrderDTO;
import com.test.sell.dataobject.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    /** 创建订单. */
    OrderDTO create(OrderDTO orderDTO);

    /** 查询单个订单. */
    OrderDTO findOne(String orderId);

    /** 创建订单列表. */
    Page<OrderDTO> findList(String buyerOpenid,Pageable pageable);

    /** 取消订单. */
    OrderDTO cancle(OrderDTO orderDTO);

    /** 完结订单. */
    OrderDTO finish(OrderDTO orderDTO);

    /** 支付订单. */
    OrderDTO paid(OrderDTO orderDTO);
}
