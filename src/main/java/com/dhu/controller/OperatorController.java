package com.dhu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dhu.pojo.Operator;
import com.dhu.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    /**
     * 添加一个新的仓库操作人员
     * Post方式提交
     * @param operator
     * @return
     */
    @PostMapping("/addOperator")
    public String addOperator(@RequestBody Operator operator){
        int rows = operatorService.addOperator(operator);
        JSONObject result = new JSONObject();
        if(rows == 1){
            result.put("code",20000);
        }else {
            result.put("code",404);
        }
        return result.toJSONString();
    }

    /**
     * 给用户名，查找该用户
     * 以get方式提交
     * @param map
     * @return
     */
    @RequestMapping(value = "/findOperatorByName",method = RequestMethod.GET)
    public String findOperatorByName(@RequestBody Map<String,String> map){
        String userName = map.get("userName");
        Operator operator = operatorService.findOperatorByName(userName);
        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();
        if(operator != null){
            result.put("code",20000);
        }else {
            result.put("code",404);
        }
        data.put("operator",operator);
        result.put("data",data);
        return result.toJSONString();
    }

    /**
     * 查询所有操作人员信息
     * @return
     */
    @RequestMapping("/findAllOperator")
    public String findAllOperator(){
        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray operatorArray;

        operatorArray = JSONArray.parseArray(
                JSON.toJSONString(operatorService.findAllOperator()));
        List<Operator> operatorList = operatorService.findAllOperator();
        result.put("code",20000);
        data.put("allOperator",operatorArray);
        result.put("data",data);
        return result.toJSONString();
    }

    /**
     *   登陆验证
     *   Post方式提交
     * @param map
     * @return
     */
    @PostMapping(value = "/login")
    public String login(@RequestBody Map<String,String> map){

        System.out.println(map.keySet());
        System.out.println(map.get("username"));
        Operator trueOperator = operatorService.findOperatorByName(map.get("username"));
        System.out.println(trueOperator);
        System.out.println(map.get("password"));
        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();
        if(trueOperator == null){
            result.put("code",400);
        }else if(trueOperator.getPassword().equals(map.get("password"))){
            data.put("token","sjfklafafafkldfae" + map.get("username"));
            result.put("code",20000);
        }else {
            result.put("code",404);
        }
        result.put("data",data);
        return result.toJSONString();
    }

    /**
     * 根据用户id修改一个用户信息，
     * 没有修改的信息也要返回，即所有信息都要返回
     * @param operator
     * @return
     */
    @PostMapping("/modifyOperator")
    public String modifyOperator(@RequestBody Operator operator){
        JSONObject result = new JSONObject();
        int rows = operatorService.updateOperator(operator);
        if(rows == 1){
            result.put("code",20000);
        }else {
            result.put("code",404);
        }
        return result.toJSONString();
    }

    /**
     * 删除一个用户
     * @param map
     * @return
     */
    @RequestMapping("/deleteOperator")
    public String deleteOperator(@RequestBody Map<String,Object> map){
        JSONObject result = new JSONObject();
        System.out.println(map);
        try {
            int id = (int) map.get("id");
            int rows = operatorService.deleteOperatorById(id);
            if(rows == 1){
                result.put("code",20000);
            }else {
                result.put("code",404);
            }
        }catch (Exception e){
            result.put("code",409);
        }
        return result.toJSONString();
    }
}
