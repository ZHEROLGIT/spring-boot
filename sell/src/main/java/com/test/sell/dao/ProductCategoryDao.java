package com.test.sell.dao;

import com.test.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @file_name: ProductCategoryDao
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/12 17:33
 * @version：
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer>{
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
