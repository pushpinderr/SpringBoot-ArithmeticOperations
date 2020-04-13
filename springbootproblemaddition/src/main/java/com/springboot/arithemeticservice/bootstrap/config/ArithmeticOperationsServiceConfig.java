package com.springboot.arithemeticservice.bootstrap.config;

import com.springboot.arithemeticservice.domain.ArithmeticOperationsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArithmeticOperationsServiceConfig {
    @Bean
    public ArithmeticOperationsService arithmeticService() {
        return new ArithmeticOperationsService();
    }
}
