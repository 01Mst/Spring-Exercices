package com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.service;

import com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();


    Employee findById(int theId);

    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
