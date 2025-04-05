package com.example.springbootpractice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Entity will make the sql table map the employee object
//@id: make primary key of the table

@Entity
@Table(name="employeeTable2")
public class Employee {


    @Column(name="fullName1")
    private String name;
    private int age;

    @Column(unique=true)
    private String email;
    private String password;
    @Id
    private String id;



    public Employee(String name, int age, String email, String password, String id) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
