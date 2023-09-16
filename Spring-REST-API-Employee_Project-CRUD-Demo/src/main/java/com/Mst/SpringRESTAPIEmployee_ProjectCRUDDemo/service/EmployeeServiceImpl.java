package com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.service;

import com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.dao.EmployeeDAO;
import com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }
@Transactional
    @Override
    public Employee save(Employee theEmployee) {
      return employeeDAO.save(theEmployee);

    }
@Transactional
    @Override
    public void deleteById(int theId) {
          employeeDAO.deleteById(theId);

    }

}
