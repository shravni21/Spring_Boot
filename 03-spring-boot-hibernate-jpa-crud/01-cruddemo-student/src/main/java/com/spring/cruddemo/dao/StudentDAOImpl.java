package com.spring.cruddemo.dao;

import com.spring.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        // Find by ID
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student ", Student.class);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        // create query  // JPA named parameters prefixed with colon
        TypedQuery<Student> thequery = entityManager.createQuery("FROM Student where last_name= : theData", Student.class);

        // set query parameters
        thequery.setParameter("theData", theLastName);

        // return query results
        return thequery.getResultList();
    }

    @Override
    @Transactional
    public void Update(Student theStudent) {
        // Update
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        // retrieve the student
        Student theStudent= entityManager.find(Student.class, id);
        // delete the student
        entityManager.remove(theStudent);
    }
}
