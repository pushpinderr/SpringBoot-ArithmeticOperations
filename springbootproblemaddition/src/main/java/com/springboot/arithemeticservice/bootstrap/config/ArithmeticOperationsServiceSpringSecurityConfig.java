package com.springboot.arithemeticservice.bootstrap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ArithmeticOperationsServiceSpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${arithmetic.service.user.id}")
    private String userId;

    @Value("${arithmetic.service.user.password}")
    private String password;

    @Value("${arithmetic.service.user.role}")
    private String role;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
                .disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.inMemoryAuthentication()
                .withUser(userId)
                .password("{noop}" + password)
                .roles(role);
    }
}