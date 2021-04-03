package com.dhu.dao;

import com.dhu.pojo.OrderDetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderDetailsMapper {

    //插入订单明细信息
    int insertOrderDetails(OrderDetails orderDetails);

    //查询订单明细信息
    List<OrderDetails> selectAllOrderDetails();

    //按照订单编号查找订单明细信息
    List<OrderDetails> selectOrderDetailsByOrdersId(Integer ordersId);

    //按照仓库查询订单明细信息
    List<OrderDetails> selectOrderDetailsByRepositoryName(String repositoryName);

    //修改订单明细信息
    int updateOrderDetails(OrderDetails orderDetails);

    //删除订单明细信息
    int deleteOrderDetails(Integer orderId);

}
