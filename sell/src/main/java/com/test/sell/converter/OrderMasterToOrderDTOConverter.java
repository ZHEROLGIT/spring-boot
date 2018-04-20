package com.test.sell.converter;

import com.test.sell.DataTransferObject.OrderDTO;
import com.test.sell.dataobject.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @file_name: OrderMasterToOrderDTOConverter
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/19 16:11
 * @version：
 */
//转换器
public class OrderMasterToOrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
