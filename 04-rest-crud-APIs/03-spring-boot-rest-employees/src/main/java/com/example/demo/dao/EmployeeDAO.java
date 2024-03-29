package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeDAO {
    List<Employee> findAll();

    Employee FindById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}

