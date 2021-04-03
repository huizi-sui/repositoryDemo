package com.dhu.service.impl;

import com.dhu.dao.OperatorMapper;
import com.dhu.pojo.Operator;
import com.dhu.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorMapper operatorMapper;

    @Override
    public int addOperator(Operator operator) {
        try {
            return operatorMapper.insertOperator(operator);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public Operator findOperatorByName(String username) {
        return operatorMapper.selectOperatorByName(username);
    }

    @Override
    public List<Operator> findAllOperator() {
        return operatorMapper.selectAllOperator();
    }

    @Override
    public int deleteOperatorById(Integer id) {
        try {
            return operatorMapper.deleteOperatorById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int updateOperator(Operator operator) {
        try {
            return operatorMapper.updateOperator(operator);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
