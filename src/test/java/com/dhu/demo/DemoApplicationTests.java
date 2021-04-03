package com.dhu.demo;

import com.dhu.pojo.Operator;
import com.dhu.service.OperatorService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private OperatorService operatorService;

    @Test
    public void contextLoads() {
        Operator operator = operatorService.findOperatorByName("zhangsan");
        System.out.println(operator);
    }

}
