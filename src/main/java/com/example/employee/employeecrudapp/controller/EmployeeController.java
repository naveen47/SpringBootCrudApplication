package com.example.employee.employeecrudapp.controller;

import java.util.List;
import java.util.Optional;

import com.example.employee.employeecrudapp.entities.Employee;
import com.example.employee.employeecrudapp.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/id/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Integer id) {
        try {
            Optional<Employee> employee = employeeService.findEmployeeById(id);
            if (employee.isPresent()) {
                return new ResponseEntity<>(employee.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAllEmployees() {

        try {
            List<Employee> employeesList = employeeService.findAllEmployees();
            if (employeesList.size() > 0) {
                return new ResponseEntity<>(employeesList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            Employee emp = employeeService.createEmployee(new Employee(employee.getId(), employee.getName(),
                    employee.getDesignation(), employee.getSalary(), employee.getCompany()));
            return new ResponseEntity<>(emp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {

        try {
            Optional<Employee> employeeData = employeeService.findEmployeeById(id);
            if (employeeData.isPresent()) {
                Employee emp = employeeData.get();
                emp.setName(employee.getName());
                emp.setDesignation(employee.getDesignation());
                emp.setSalary(employee.getSalary());
                emp.setCompany(employee.getCompany());
                return new ResponseEntity<>(employeeService.createEmployee(emp), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Integer id) {
        try {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteAllEmployees() {
        try {
            employeeService.deleteAllEmployee();

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employee/{name}")
    public ResponseEntity<List<Employee>> findEmployeeByName(@PathVariable("name") String name) {
        try {
            List<Employee> empList = employeeService.findEmployeeByName(name);

            if (empList.size() > 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(empList, HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/employee/{designation}")
    public ResponseEntity<List<Employee>> findEmployeeByDesignation(@PathVariable("designation") String designation) {
        try {
            List<Employee> empList = employeeService.findEmployeeByDesignation(designation);

            if (empList.size() > 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(empList, HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
