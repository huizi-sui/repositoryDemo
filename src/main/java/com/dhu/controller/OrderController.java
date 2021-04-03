package com.dhu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dhu.pojo.OrderDetails;
import com.dhu.pojo.Orders;
import com.dhu.service.OrderDetailsService;
import com.dhu.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * Orders表和OrderDetails表都在这里进行处理
 */
@RestController
public class OrderController {
    @Resource
    private OrdersService ordersService;
    @Autowired
    private OrderDetailsService orderDetailsService;

    /**
     * 查询所有订单信息
     * @return
     */
    @RequestMapping(value = "/findAllOrders")
    public String findAllOrders(){
        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray resultArray;
        resultArray = JSONArray.parseArray(JSON.
                toJSONString(ordersService.findAllOrders()));

        result.put("code", 20000);
        result.put("data", data);
        data.put("result",resultArray);
        return result.toJSONString();
    }

    /**
     * 查询某个仓库的所有订单信息
     * @param repositoryName 获得请求参数中的仓库编号
     * @return
     */
    @RequestMapping(value = "/findOrderByRepositoryName")
    public String findOrdersByRepositoryName(@RequestParam String repositoryName) {
        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray resultArray;
        resultArray = JSONArray.parseArray(JSON.toJSONString(ordersService.
                findOrdersByRepositoryName(repositoryName)));

        result.put("code", 20000);
        result.put("data", data);
        data.put("result",resultArray);
        return result.toJSONString();
    }

    @RequestMapping("/addOrders")
    @Transactional(rollbackFor = Exception.class)
    public String addOrders(@RequestBody JSONObject jsonObject){

        JSONObject jsonOrders = jsonObject.getJSONObject("orders");
        JSONArray jsonOrderDetails = jsonObject.getJSONArray("orderDetails");

        Orders orders = jsonOrders.toJavaObject(Orders.class);
        List<OrderDetails> orderDetailsList = jsonOrderDetails.toJavaList(OrderDetails.class);

        JSONObject result = new JSONObject();

        int rows = ordersService.addOrder(orders);
        boolean success = true;
        for (OrderDetails details : orderDetailsList) {
            if (orderDetailsService.addOrderDetails(details) == -1){
                success = false;
            }
        }
        if (rows == 1 && success){
            result.put("code",20000);
        }else {
            result.put("code",404);
        }

        return result.toJSONString();
    }
}
