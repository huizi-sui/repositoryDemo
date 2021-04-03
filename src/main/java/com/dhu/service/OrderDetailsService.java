package com.dhu.service;

import com.dhu.pojo.OrderDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrderDetailsService {
    //插入订单明细信息
    int addOrderDetails(OrderDetails orderDetails);

    //查询订单明细信息
    List<OrderDetails> findAllOrderDetails();

    //按照订单编号查找订单明细信息
    List<OrderDetails> findOrderDetailsByOrdersId(Integer ordersId);

    //按照仓库查询订单明细信息
    List<OrderDetails> findOrderDetailsByRepositoryName(String repositoryName);

    //修改订单明细信息
    int updateOrderDetails(OrderDetails orderDetails);

    //删除订单明细信息
    int deleteOrderDetails(Integer orderId);
}
