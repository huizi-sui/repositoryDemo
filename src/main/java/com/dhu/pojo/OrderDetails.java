package com.dhu.pojo;

import lombok.Data;

//订单的明细
@Data
public class OrderDetails {
    //订单编号，主键
    private Integer orderId;
    //产品编号
    private String productId;
    //产品名称
    private String productName;
    //产品类型
    private String productCategory;
    //产品采购价格
    private Double buyPrice;
    //产品采购数量
    private Integer buyNumber;
    //产品采购总价格
    private Double buyAllPrice;
}
