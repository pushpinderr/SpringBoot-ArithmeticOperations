package com.springboot.arithemeticservice.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.springboot.arithemeticservice")
@SpringBootApplication
public class SpringBootArithmeticOperationsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootArithmeticOperationsApplication.class, args);
    }
}