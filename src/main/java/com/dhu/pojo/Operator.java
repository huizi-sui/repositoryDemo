package com.dhu.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Operator {
    //用户id 主键
    private Integer id;
    //用户角色id
    private Integer rid;
    //用户名称
    private String userName;
    //用户密码
    private String password;
    //用户邮箱
    private String email;
}
