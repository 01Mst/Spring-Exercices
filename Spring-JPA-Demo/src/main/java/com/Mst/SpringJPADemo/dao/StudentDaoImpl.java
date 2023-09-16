package com.Mst.SpringJPADemo.dao;

import com.Mst.SpringJPADemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDAO{

    public EntityManager entityManager;

    public  StudentDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    @Override
    public Student read(int id) {
       return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> TheQuery=entityManager.createQuery("FROM Student", Student.class);
        return TheQuery.getResultList();
    }



    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> TheQuery=entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
        TheQuery.setParameter("theData",lastName);
        return TheQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStu=entityManager.find(Student.class,id);
        entityManager.remove(theStu);
    }

    @Override
    @Transactional

    public int deleteAll() {
        int numofRows=entityManager.createQuery("DELETE FROM Student").executeUpdate();
       return  numofRows;

    }
}
