package com.dhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling//开启定时功能
public class HrSystem {

    public static void main(String[] args) {
        SpringApplication.run(HrSystem.class, args);
    }

}