package com.dhu.service;

import com.dhu.pojo.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrdersService {
    //查询所有订单
    List<Orders> findAllOrders();

    //按仓库名称查找订单
    List<Orders> findOrdersByRepositoryName(String repository);

    //插入订单
    int addOrder(Orders orders);

    //按照订单编号删除订单
    int deleteOrderById(Integer id);

    //更改订单信息,根据订单编号
    int updateOrdersById(Orders orders);
}
