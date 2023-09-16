package com.Mst.SpringJPADemo.dao;

import com.Mst.SpringJPADemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student read(int id);

    List<Student> findAll();


    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
