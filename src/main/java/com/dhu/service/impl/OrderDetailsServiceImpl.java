package com.dhu.service.impl;

import com.dhu.dao.OrderDetailsMapper;
import com.dhu.pojo.OrderDetails;
import com.dhu.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    @Override
    public int addOrderDetails(OrderDetails orderDetails) {
        try {
            return orderDetailsMapper.insertOrderDetails(orderDetails);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<OrderDetails> findAllOrderDetails() {
        return orderDetailsMapper.selectAllOrderDetails();
    }

    @Override
    public List<OrderDetails> findOrderDetailsByOrdersId(Integer ordersId) {
        return orderDetailsMapper.selectOrderDetailsByOrdersId(ordersId);
    }

    @Override
    public List<OrderDetails> findOrderDetailsByRepositoryName(String repositoryName) {
        return orderDetailsMapper.selectOrderDetailsByRepositoryName(repositoryName);
    }

    @Override
    public int updateOrderDetails(OrderDetails orderDetails) {
        try {
            return orderDetailsMapper.updateOrderDetails(orderDetails);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int deleteOrderDetails(Integer orderId) {
        try {
            return orderDetailsMapper.deleteOrderDetails(orderId);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
