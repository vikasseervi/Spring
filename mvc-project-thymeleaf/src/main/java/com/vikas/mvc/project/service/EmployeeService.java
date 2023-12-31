package com.vikas.mvc.project.service;

import com.vikas.mvc.project.entity.Employee;

import java.util.List;

// @Transactional will be handled by Service layer instead of DAO layer
public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
