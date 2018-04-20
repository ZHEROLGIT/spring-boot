package com.test.sell.dao;

import com.test.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailDao extends JpaRepository<OrderDetail,String>{
    List<OrderDetail> findByOrderId(String orderiId);
}
