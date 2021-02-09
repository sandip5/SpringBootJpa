package com.sandip.spring.hibernatejpa.hibernatejpa.repository;

import com.sandip.spring.hibernatejpa.hibernatejpa.entity.Course;
import com.sandip.spring.hibernatejpa.hibernatejpa.entity.Passport;
import com.sandip.spring.hibernatejpa.hibernatejpa.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class StudentRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Student findById(long id) {
        return em.find(Student.class, id);
    }

    public void deleteById(int id) {
        em.remove(findById(id));
    }

    public Student save(Student student) {
        if(student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }
        return student;
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("M12345");
        em.persist(passport);
        Student student = new Student("Monu");
        student.setPassport(passport);
        em.persist(student);
    }

    public void insertStudentAndCourse() {
        Student student = new Student("Jai");
        Course course = new Course("MicroServices");
        em.persist(student);
        em.persist(course);
        student.addCourse(course);
        course.addStudent(student);
        em.persist(student);
    }

    public void insertStudentAndCourse(String studentName, List<Course> courses) {
        Student student = new Student(studentName);
        for (Course course : courses) {
            student.addCourse(course);
            course.addStudent(student);
            em.persist(student);
            em.persist(course);

        }
    }

    public void insertStudentsAndCourse(List<Student> students, String courseName) {
        Course course = new Course(courseName);
        for (Student student : students) {
            student.addCourse(course);
            course.addStudent(student);
            em.persist(student);
            em.persist(course);
        }
    }
}
