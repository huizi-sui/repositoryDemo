package com.dhu.service.impl;

import com.dhu.dao.OrdersMapper;
import com.dhu.pojo.Orders;
import com.dhu.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> findAllOrders() {
        return ordersMapper.selectAllOrders();
    }

    @Override
    public List<Orders> findOrdersByRepositoryName(String repositoryName) {
        return ordersMapper.selectOrdersByRepositoryName(repositoryName);
    }

    @Override
    public int addOrder(Orders orders) {
        try {
            return ordersMapper.insertOrder(orders);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int deleteOrderById(Integer id) {
        try{
            return ordersMapper.deleteOrderById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int updateOrdersById(Orders orders) {
        try{
            return ordersMapper.updateOrdersById(orders);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        }
}
