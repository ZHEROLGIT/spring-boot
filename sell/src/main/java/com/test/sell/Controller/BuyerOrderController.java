package com.test.sell.Controller;

import com.test.sell.VO.ResultVO;
import com.test.sell.enums.ResultEnums;
import com.test.sell.exception.SellException;
import com.test.sell.form.OrderForm;
import com.test.sell.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * @file_name: BuyerOrderController
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/20 16:06
 * @version：
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    Logger log = LoggerFactory.getLogger(BuyerOrderController.class);
    //创建订单
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        throw new SellException(ResultEnums.PARAM_ERROR)
    }
    //订单列表

    //订单详情

    //取消订单
}
