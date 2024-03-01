package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> findAll();

    Employee FindById(int theId);


    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
