package com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.dao;

import com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);
    void deleteById(int theId);


}
