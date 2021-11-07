package com.salahbkd.springresttraining.controller;

import com.salahbkd.springresttraining.dao.EmployeeDAO;
import com.salahbkd.springresttraining.entity.Employee;
import com.salahbkd.springresttraining.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        var employee =  employeeService.findById(employeeId);

        if(employee == null)
            throw new RuntimeException("employee not found with id: " + employeeId);

        return employee;
    }

    @PostMapping("/employees")
    public Employee getEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        var employee = employeeService.findById(employeeId);

        if(employee == null)
            throw new RuntimeException("employee id not found " + employeeId);

        employeeService.deleteById(employeeId);

        return "deleted employee with id" + employeeId;
    }

}
