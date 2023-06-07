package org.example.config;

import org.example.domain.Employee;
import org.example.domain.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public HelloWorld getHelloWorld(){
        return new HelloWorld();
    }

    @Bean
    public Employee getEmployee(){
        return new Employee();
    }
}
