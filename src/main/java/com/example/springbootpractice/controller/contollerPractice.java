package com.example.springbootpractice.controller;

import com.example.springbootpractice.model.Employee;
import com.example.springbootpractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// @RestController will accept only REST call (HTTP) and will return different type
//@Controller will return HTML page name or reference only
@RestController
@RequestMapping(value="/v1")

public class contollerPractice {


// autowire create a reference of the bean (singleton object) that exist
@Autowired
public EmployeeService employeeService ;

    // RequestMapping then Get or POSt PUT
    @RequestMapping(value="/FirstApi",method= RequestMethod.GET)
    public String mehod1() {
        return "Hello - First API";
    }

    @GetMapping(value="/SecondApi")
    public String method2(@RequestParam String firstName ,@RequestParam(required=false,name="var2",defaultValue="DefaultName") String lastName) {

        return "Full Name {"+firstName+" "+lastName+"}";
    }

    @GetMapping(value="/ThirdApi/{var1}")
    public String method3(@PathVariable(name="var1") String Name) {
        return Name;
    }

    // we will receive employee object from UI.
    @PostMapping(value="/FourthAPI")
    public Employee method4(@RequestBody Employee employee) {
        return employee;
    }

    // Register Employee
    @PostMapping(value="/Register")
    public Employee method5(@RequestBody Employee employee) {
    Employee newEmployee = employeeService.registerEmployee(employee);
        return newEmployee;
    }


}

