package com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.dao;

import com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositoryJPA extends JpaRepository<Employee,Integer> {
}
