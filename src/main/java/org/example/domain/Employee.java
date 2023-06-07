package org.example.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Employee {

    public Employee getEmployee(){
        return new Employee();
    }
}
