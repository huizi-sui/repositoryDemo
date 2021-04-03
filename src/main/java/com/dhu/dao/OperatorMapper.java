package com.dhu.dao;

import com.dhu.pojo.Operator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OperatorMapper {

    //插入用户
    int insertOperator(Operator operator);

    //按用户名检索用户
    Operator selectOperatorByName(String username);
    //查询所有用户信息
    List<Operator> selectAllOperator();

    //删除一个用户
    int deleteOperatorById(Integer id);

    //更改一个用户信息
    int updateOperator(Operator operator);
}
