package com.example.springbootpractice.controller;

import com.example.springbootpractice.model.Employee;
import com.example.springbootpractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

// @RestController will accept only REST call (HTTP) and will return different type
//@Controller will return HTML page name or reference only
@RestController
@RequestMapping(value="/v1")

public class contollerPractice {


    // autowire create a reference of the bean (singleton object) that exist
    @Autowired
    public EmployeeService employeeService;

    // RequestMapping then Get or POSt PUT
    @RequestMapping(value = "/FirstApi", method = RequestMethod.GET)
    public String mehod1() {
        return "Hello - First API";
    }

    @GetMapping(value = "/SecondApi")
    public String method2(@RequestParam String firstName, @RequestParam(required = false, name = "var2", defaultValue = "DefaultName") String lastName) {

        return "Full Name {" + firstName + " " + lastName + "}";
    }

    @GetMapping(value = "/ThirdApi/{var1}")
    public String method3(@PathVariable(name = "var1") String Name) {
        return Name;
    }

    // we will receive employee object from UI.
    @PostMapping(value = "/FourthAPI")
    public Employee method4(@RequestBody Employee employee) {
        return employee;
    }

    // Register Employee
    @PostMapping(value = "/Register")
    public ResponseEntity<?> method5(@RequestBody Employee employee) {
         return employeeService.registerEmployee(employee);

    }

    //
    @GetMapping(value = "/GetAllEmployees")
    public List<Employee> method6() {
        return employeeService.getAllaEmployee();
    }

    @GetMapping(value = "/GetEmployeeBYId")
    public ResponseEntity<Employee> method7(@RequestParam int ID) {
        return employeeService.getEmployeeBYId(ID);
    }


    @GetMapping(value = "/GetEmployeeBYEmail")
    public Employee method8(@RequestParam String EMAIL) {
        return employeeService.getEmployeeBYEMAIL(EMAIL);
    }

    // HW: create an API to update record put using putMapping


    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        return updatedEmployee;
    }

    // change password
    @GetMapping(value="/changePassword")
    public String changepassword(@RequestParam String Email, @RequestParam String Newpassword, @RequestParam String OldPassword) {


      return employeeService.changePassword(Email, Newpassword, OldPassword);

    }

    //login account
    @GetMapping(value="/login")
    public String Login(@RequestParam String email, @RequestParam String password) {

       return employeeService.loginUser(email, password );
    }


    //forget password
    @GetMapping(value="/forgetPassword")
    public ResponseEntity<?> ForgetPassword(@RequestParam String email, @RequestParam String Name, @RequestParam String newPassword) {

        return employeeService.forgetUserPasswrd(email,Name,newPassword);
    }



    //deletebyEMAIL
    @DeleteMapping(value="/deleteEmployee")
    public ResponseEntity <?> deleteEmployee(@RequestParam String email) {

        return employeeService.deleteEmployeebyID( email) ;
    }

    //deleteAll
     @DeleteMapping(value="/deleteEmployeeAll")
    public ResponseEntity <?> deleteEmployeeAll() {

        return employeeService.deleteEmployeeAllimp();
    }


}