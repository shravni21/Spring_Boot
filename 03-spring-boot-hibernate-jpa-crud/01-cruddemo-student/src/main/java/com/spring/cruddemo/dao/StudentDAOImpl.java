package com.spring.cruddemo.dao;

import com.spring.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository  //---> specialized annotation for repositories, supports component scanning, translates JDBC exceptions
public class StudentDAOImpl implements StudentDAO {

    // Define field for entity manager
    private EntityManager entityManager;

    // Inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement save method
    @Override
    @Transactional //--> since we are performing an update
    public void save(Student TheStudent) {
        entityManager.persist(TheStudent);
    }

    @Override
    public Student FIndbyId(Integer id) {
        return entityManager.find(Student.class, id);
    }
}
