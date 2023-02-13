package com.example.demo.repository;

import com.example.demo.model.jpa.Student;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.example.demo.model.jpa.QStudent.student;

@Repository
public class StudentRepositoryWithJpa {
    @Autowired
    private JPAQueryFactory queryFactory;

    public List<Student> findAll() {
        return queryFactory.selectFrom(student).fetch();
    }


    @PersistenceContext
    EntityManager entityManager;



    public Student findById(int id) {
        return entityManager.find(Student.class, id);// JPA
    }

    public Student update(Student student) {
        return entityManager.merge(student);
    }
    public Student insert(Student student) {
        return entityManager.merge(student);
    }

    public void deleteById(int id) {
        Student person = findById(id);
        entityManager.remove(student);
    }
}
