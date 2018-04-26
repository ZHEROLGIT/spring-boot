package com.test.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.sell.Controller.BuyerOrderController;
import com.test.sell.DataTransferObject.OrderDTO;
import com.test.sell.dataobject.OrderDetail;
import com.test.sell.enums.ResultEnums;
import com.test.sell.exception.SellException;
import com.test.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @file_name: OrderFormToOrderDTOConverter
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/23 16:08
 * @version：
 */
@Slf4j
public class OrderFormToOrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        Logger log = LoggerFactory.getLogger(OrderFormToOrderDTOConverter.class);
        Gson gson = new Gson();
//        BeanUtils.copyProperties  为什么不用这个，主要是orderForm的属性名称跟orderDTO里面的属性名称不一样。比如BuyerName和Name。
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try{
           orderDetailList = gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e){
            log.error("【对象转换】错误，string={}",orderForm.getItems());
            throw new SellException(ResultEnums.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
