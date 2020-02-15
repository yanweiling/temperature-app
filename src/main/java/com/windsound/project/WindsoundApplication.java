package com.windsound.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.windsound.project.mapper")
public class WindsoundApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(WindsoundApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(WindsoundApplication.class);
    }
}
