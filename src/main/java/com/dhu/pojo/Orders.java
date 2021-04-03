package com.dhu.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

//订单
@Data
public class Orders {
    //订单编号，主键
    private Integer id;
    //订单日期
    @JSONField(format = "yyyy-MM-dd")
    private Date date;
    //订单供应商
    private String supplier;
    //发出订单的仓库
    private String repositoryName;
    //明细
    private String detail;
}
