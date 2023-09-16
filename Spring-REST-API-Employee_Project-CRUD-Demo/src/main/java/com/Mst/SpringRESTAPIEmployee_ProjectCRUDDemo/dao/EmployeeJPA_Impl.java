package com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.dao;

import com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeJPA_Impl implements EmployeeDAO{


    private EntityManager entity_Manager;

    @Autowired
    public EmployeeJPA_Impl(EntityManager entity_Manager) {
        this.entity_Manager = entity_Manager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery=entity_Manager.createQuery("from Employee", Employee.class);
        List<Employee> employees=theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee employee=entity_Manager.find(Employee.class,theId);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee employee=entity_Manager.merge(theEmployee);
        return employee;

    }

    @Override
    public void deleteById(int theId) {

        Employee employee=entity_Manager.find(Employee.class,theId);
        entity_Manager.remove(employee);
    }


}
