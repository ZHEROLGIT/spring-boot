package com.test.sell.service.impl;

import com.test.sell.DataTransferObject.CartDTO;
import com.test.sell.dao.ProductInfoDao;
import com.test.sell.dataobject.ProductInfo;
import com.test.sell.enums.ProductStatusEnums;
import com.test.sell.enums.ResultEnums;
import com.test.sell.exception.SellException;
import com.test.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @file_name: ProductInfoServiceImpl
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/13 14:27
 * @version：
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService{
    @Autowired
    private ProductInfoDao dao;

//    @Autowired
//    private ProductInfo productInfo;

    public ProductInfoServiceImpl() {
        super();
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList){
            System.out.println(cartDTO.getProductId());
            Optional<ProductInfo> productInfo = dao.findById(cartDTO.getProductId());
            ProductInfo productInfo1 = new ProductInfo();
            if(productInfo.isPresent()){
               productInfo1  = productInfo.get();
            }
            System.out.println(productInfo1.toString());
            long result = productInfo1.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0){
                throw new SellException(ResultEnums.PRODUCT_STOCK_ERROR);
            }
            productInfo1.setProductStock((int)result);
            dao.save(productInfo1);
        }
    }

    @Override
    public Optional<ProductInfo> findById(String productId) {
        return dao.findById(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return dao.findByProductStatus(ProductStatusEnums.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return dao.save(productInfo);
    }
}
