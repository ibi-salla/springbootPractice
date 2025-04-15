package com.example.springbootpractice.service;

import com.example.springbootpractice.model.Employee;
import com.example.springbootpractice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

//  annotation = Component.class will make create a bean. @service has ( annotation = Component.class) therefore it will make EntiteeService bean
@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository repository;

    public ResponseEntity<?> registerEmployee(Employee employee) {

        Employee findemployee = repository.findByEmail(employee.getEmail());

        if (findemployee == null) {

                return ResponseEntity.ok(repository.save(employee));

            }
        return new ResponseEntity<>("Email already existed",HttpStatus.NOT_FOUND);
    }


    public List<Employee> getAllaEmployee() {
        List<Employee> employees = repository.findAll();
        return  employees;
    }

    public ResponseEntity<Employee> getEmployeeBYId(int id) {
        Employee employeebyId = repository.findById(id).get();
        return  ResponseEntity.ok(employeebyId);

    }

    public Employee getEmployeeBYEMAIL(String email) {
        return repository.findByEmail(email);
    }

    public Employee updateEmployee(int id, Employee employeeDetails) {

            Employee result = repository.findById(id).get();
            result.setName(employeeDetails.getName());
            result.setAge(employeeDetails.getAge());
            result.setEmail(employeeDetails.getEmail());
            result.setPassword(employeeDetails.getPassword());
            return repository.save(result);
    }

    public String changePassword(String Email,String Newpassword, String OldPassword) {

        Employee result = repository.findByEmail(Email);

        if (result.getPassword().equals(OldPassword)) {
            result.setPassword(Newpassword);
            repository.save(result);
            return "Password changed successfully";
        }

       return "Wrong Password";

    }

    public String loginUser(String email, String password) {

        Employee employee = repository.findByEmail(email);
        if (employee!=null) {
            if (employee.getPassword().equals(password)) {
                return "Logged in successfully";
            }
        }
        return "Password or Email doesn't match";

    }

    public ResponseEntity<?> forgetUserPasswrd(String email, String name, String newPassword) {


         Employee employee = repository.findByEmail(email);
         if (employee!=null) {

             if (employee.getEmail().equals(email) && employee.getName().equals(name)) {

                 // always save after set
                 employee.setPassword(newPassword);
                 repository.save(employee);

                // return "Password changed successfully";
                 return ResponseEntity.ok("Password changed successfully");
             }
            // return "Email and name do not match";


            // return new ResponseEntity(400,);
             return new ResponseEntity<>("Wrong Password", HttpStatus.BAD_REQUEST);

         }

        return new ResponseEntity<>("Email doesn't match", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> deleteEmployeebyID(String email) {

        Employee employee = repository.findByEmail(email);
        if (employee!=null) {

            repository.delete(employee);
        return ResponseEntity.ok("Employee deleted successfully");
    }
        return new ResponseEntity<>("Email doesn't match", HttpStatus.NOT_FOUND);
}
    public ResponseEntity<?> deleteEmployeeAllimp() {
        repository.deleteAll();
        return ResponseEntity.ok("Employees deleted successfully");
    }


    //
}
