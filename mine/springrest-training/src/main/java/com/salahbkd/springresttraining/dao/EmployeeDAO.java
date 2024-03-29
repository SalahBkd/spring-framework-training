package com.salahbkd.springresttraining.dao;

import com.salahbkd.springresttraining.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);

}
