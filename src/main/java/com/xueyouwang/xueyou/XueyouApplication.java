package com.xueyouwang.xueyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xueyouwang.xueyou.dao")
public class XueyouApplication {

    public static void main(String[] args) {
        SpringApplication.run(XueyouApplication.class, args);
    }

}
