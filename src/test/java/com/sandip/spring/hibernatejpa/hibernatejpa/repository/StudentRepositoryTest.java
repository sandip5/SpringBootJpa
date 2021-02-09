package com.sandip.spring.hibernatejpa.hibernatejpa.repository;

import com.sandip.spring.hibernatejpa.hibernatejpa.HibernatejpaApplication;
import com.sandip.spring.hibernatejpa.hibernatejpa.entity.Course;
import com.sandip.spring.hibernatejpa.hibernatejpa.entity.Passport;
import com.sandip.spring.hibernatejpa.hibernatejpa.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernatejpaApplication.class)
public class StudentRepositoryTest {
    @Autowired
    StudentRepository repo;

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    @Transactional
    public void retrieveStudentPassportDetails() {
        logger.info("Test is running");
        Student student = em.find(Student.class, 20001L);
        logger.info("Student Details -> {}", student);
        logger.info("Student Passport Details -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrievePassportAssociatedWithStudent() {
        Passport passport = em.find(Passport.class, 40001L);
        logger.info("Passport -> {}", passport);
        logger.info("Student -> {}",passport.getStudent());
    }

    @Test
    @Transactional
    public void retrieveStudentAndCourses() {
        Student student = em.find(Student.class, 20001L);
        logger.info("Student -> {}", student);
        logger.info("Courses -> {}",student.getCourses());
    }

}
