package com.test.sell.service.impl;

import com.test.sell.dao.ProductCategoryDao;
import com.test.sell.dataobject.ProductCategory;
import com.test.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @file_name: ProductCategoryServiceImpl
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/13 11:12
 * @version：
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
    @Autowired
    private ProductCategoryDao dao;

    @Override
    public Optional<ProductCategory> findById(Integer categoryId) {
        return dao.findById(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return dao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return dao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return dao.save(productCategory);
    }
}
