package com.example.springbootpractice.repository;

import com.example.springbootpractice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

// JapRepository (TABLE_NAME, PRIMARY_KEY TYPE)
public interface  EmployeeRepository extends JpaRepository<Employee,Integer> {

}

