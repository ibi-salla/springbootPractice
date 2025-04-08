package com.example.springbootpractice.service;

import com.example.springbootpractice.model.Employee;
import com.example.springbootpractice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//  annotation = Component.class will make create a bean. @service has ( annotation = Component.class) therefore it will make EntiteeService bean
@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository repository;

    public Employee registerEmployee(Employee employee) {
        return repository.save(employee);

    }

}
