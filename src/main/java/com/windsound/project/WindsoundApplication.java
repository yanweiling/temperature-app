package com.windsound.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.windsound.project.mapper")
public class WindsoundApplication {

    public static void main(String[] args) {
        SpringApplication.run(WindsoundApplication.class, args);
    }

}
