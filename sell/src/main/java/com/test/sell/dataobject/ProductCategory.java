package com.test.sell.dataobject;


import org.hibernate.annotations.DynamicUpdate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


import javax.persistence.*;

/**
 * @file_name: ProductCategory
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/12 17:26
 * @version：
 */
@Entity
@DynamicUpdate
public class ProductCategory {
    @Id
    private int categoryId;   //类目id
    @Column
    private String categoryName;  //类目名字

    private int categoryType;  //类目编号

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categorId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }


}
