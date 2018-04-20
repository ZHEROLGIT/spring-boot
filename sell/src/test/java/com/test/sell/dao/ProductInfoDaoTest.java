package com.test.sell.dao;

import com.test.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {
    @Autowired
    private ProductInfoDao dao;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1501");
        productInfo.setProductName("最终幻想pc版本");
        productInfo.setProductPrice(new BigDecimal(300));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("acg风格游戏，画面超级棒");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(4);

        ProductInfo result =  dao.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = dao.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfos.size());
    }
}