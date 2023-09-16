package com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.controller;

import com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.entity.Employee;
import com.Mst.SpringRESTAPIEmployee_ProjectCRUDDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeDaoController {

    private EmployeeService employeeService;
@Autowired
    public EmployeeDaoController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployee(){

        return employeeService.findAll();

    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
    Employee theEmployee=employeeService.findById(employeeId);
    if(theEmployee==null){
        throw new RuntimeException("Element Id is not found: "+employeeId);
    }
    return  theEmployee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee theEmployee){
    theEmployee.setId(0);
    Employee dbEmployee=employeeService.save(theEmployee);
    return dbEmployee;
    }

    @PutMapping("/employees")
    public  Employee updateEmployee(@RequestBody Employee theEmployee){
    Employee updateEmployee=employeeService.save(theEmployee);
    return updateEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
    Employee tempEmployee=employeeService.findById(employeeId);
    if(tempEmployee==null){
        throw  new RuntimeException("Element ID is not found: "+employeeId);
    }
    employeeService.deleteById(employeeId);
    return "Element ID is deleted :"+employeeId;
    }




















}
