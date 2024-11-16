package com.example.taskone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class MySpringBootAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootAppApplication.class, args);
    }
}