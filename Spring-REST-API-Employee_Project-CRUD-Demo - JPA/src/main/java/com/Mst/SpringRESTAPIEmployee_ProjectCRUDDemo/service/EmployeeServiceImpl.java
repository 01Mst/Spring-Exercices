package com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.service;

import com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.dao.EmployeeRepositoryJPA;
import com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepositoryJPA empJPA;
    @Override
    public List<Employee> findAll() {
        return empJPA.findAll();
    }

    @Autowired
    public EmployeeServiceImpl(EmployeeRepositoryJPA theEmpJPA){
        this.empJPA=theEmpJPA;
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = empJPA.findById(theId);
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee=result.get();
        }else{
            throw  new RuntimeException("Element id id not found+"+theId);
        }
        return theEmployee;
    }
@Transactional
    @Override
    public Employee save(Employee theEmployee) {
      return empJPA.save(theEmployee);

    }
@Transactional
    @Override
    public void deleteById(int theId) {
          empJPA.deleteById(theId);

    }

}
