package com.example.demo.service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDao) {
        employeeDAO = theEmployeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee FindById(int theId) {
        return employeeDAO.FindById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional // Transactional behavior at method level
    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
