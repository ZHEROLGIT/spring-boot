package com.test.sell.service.impl;

import com.test.sell.dataobject.ProductCategory;
import com.test.sell.dataobject.ProductInfo;
import com.test.sell.enums.ProductStatusEnums;
import com.test.sell.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findById() throws Exception{
        Optional<ProductInfo> productInfo = productInfoService.findById("1501");
//        ProductInfo result = productInfo.get();
        Assert.assertEquals("1501",productInfo.get().getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = productInfoService.findUpAll();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,1);
        Page<ProductInfo> result = productInfoService.findAll(request);
        Assert.assertNotEquals(0,request.getPageSize());
        System.out.println(result.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1502");
        productInfo.setProductName("超级马里奥");
        productInfo.setProductPrice(new BigDecimal(500));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("任天堂出品，必属精品");
        productInfo.setProductIcon("http://rtt.jpg");
        productInfo.setProductStatus(ProductStatusEnums.DOWN.getCode());
        productInfo.setCategoryType(4);
        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }
}