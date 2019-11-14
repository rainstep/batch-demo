package com.example.cachedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.example.batchdemo.dao.mybatis.mapper")
@SpringBootApplication
public class BatchDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchDemoApplication.class, args);
    }

}
