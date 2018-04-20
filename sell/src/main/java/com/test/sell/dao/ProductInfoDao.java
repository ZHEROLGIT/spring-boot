package com.test.sell.dao;

import com.test.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoDao extends JpaRepository<ProductInfo,String>{
    List<ProductInfo> findByProductStatus(Integer productStatus);
//    ProductInfo findProductInfoByProductId(ProductInfo productInfo);
}
