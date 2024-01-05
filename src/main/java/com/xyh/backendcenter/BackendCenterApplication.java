package com.xyh.backendcenter;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xyh.backendcenter.mapper")
public class BackendCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendCenterApplication.class, args);
    }

}
