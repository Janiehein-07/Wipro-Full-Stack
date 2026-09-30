package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Student;

@Repository
public class StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // ADD
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    // DISPLAY
    public List<Student> getAllStudents() {

        return entityManager
                .createQuery(
                    "SELECT s FROM Student s",
                    Student.class
                )
                .getResultList();
    }

    // SEARCH
    public Student getStudent(int regno) {

        return entityManager.find(
                Student.class,
                regno
        );
    }

    // UPDATE
    @Transactional
    public void update(Student student) {

        entityManager.merge(student);
    }

    // DELETE
    @Transactional
    public void delete(int regno) {

        Student student =
                entityManager.find(
                        Student.class,
                        regno
                );

        if (student != null) {
            entityManager.remove(student);
        }
    }
}