package com.dhu.service;

import com.dhu.pojo.Operator;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OperatorService {
    //插入用户
    int addOperator(Operator operator);

    //检索用户是否存在
    Operator findOperatorByName(String username);

    //查询所有用户信息
    List<Operator> findAllOperator();

    //删除一个用户
    int deleteOperatorById(Integer id);

    //更改一个用户信息
    int updateOperator(Operator operator);
}
