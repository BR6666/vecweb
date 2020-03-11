package com.foxgod.vecweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.foxgod.vecweb.mapper")
public class VecwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(VecwebApplication.class, args);

    }

}
