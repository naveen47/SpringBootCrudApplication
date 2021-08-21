package com.example.employee.employeecrudapp.service;

import java.util.List;
import java.util.Optional;

import com.example.employee.employeecrudapp.entities.Employee;
import com.example.employee.employeecrudapp.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Optional<Employee> findEmployeeById(Integer id) {

        return employeeRepository.findById(id);

    }

    public List<Employee> findAllEmployees() {

        return employeeRepository.findAll();

    }

    public Employee createEmployee(Employee employee) {

        return employeeRepository.save(employee);

    }


    public void deleteEmployee(Integer id) {

        employeeRepository.deleteById(id);

    }

    public void deleteAllEmployee() {

        employeeRepository.deleteAll();

    }

    public List<Employee> findEmployeeByName(String name) {

        return employeeRepository.findByName(name);

    }

    public List<Employee> findEmployeeByDesignation(String designation) {

        return employeeRepository.findEmployeeByDesignation(designation);

    }



}
