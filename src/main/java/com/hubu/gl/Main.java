package com.hubu.gl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.hubu.gl"})
@MapperScan("com.hubu.gl.dao.mapper")
public class Main {


    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

}