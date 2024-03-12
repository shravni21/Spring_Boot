package com.springboot.onetoone.demo.dao;

import com.springboot.onetoone.demo.entity.Course;
import com.springboot.onetoone.demo.entity.Instructor;
import com.springboot.onetoone.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {
    // Define field for entity manager
    private EntityManager entityManager;

    // Inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        // Retrieve the instructor

        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        // get the courses
        List<Course> courses = tempInstructor.getCourses();

        // break association of all courses for the instructor
        for (Course tempCourse : courses) {
            tempCourse.setInstructor(null);
        }

        // Delete the instructor
        entityManager.remove(tempInstructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        // retrieve the instructor detail by id
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        // Remove the associated object reference
        // break bi-directional link

        tempInstructorDetail.getInstructor().setInstructorDetail(null);
        // Delete the instructor detail
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        // create the query
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id= :data", Course.class);

        query.setParameter("data", theId);
        // Execute the query
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        // Create query
        /*
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " +
                        " join fetch i.courses "
                        + "where i.id = :id", Instructor.class);
        */
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " +
                        "join fetch i.courses " +
                        "join fetch i.instructorDetail " +
                        "where i.id = :id", Instructor.class
        );

        query.setParameter("id", theId);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }
}





