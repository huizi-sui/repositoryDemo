package com.dhu.dao;

import com.dhu.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrdersMapper {
    //查询所有订单
    List<Orders> selectAllOrders();

    //按仓库名称查找订单
    List<Orders> selectOrdersByRepositoryName(String repository);

    //插入订单
    int insertOrder(Orders orders);

    //按照订单编号删除订单
    int deleteOrderById(Integer id);

    //更改订单信息,根据订单编号
    int updateOrdersById(Orders orders);
}
