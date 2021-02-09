package com.sandip.spring.hibernatejpa.hibernatejpa;

import com.sandip.spring.hibernatejpa.hibernatejpa.entity.*;
import com.sandip.spring.hibernatejpa.hibernatejpa.repository.CourseRepository;
import com.sandip.spring.hibernatejpa.hibernatejpa.repository.EmployeeRepository;
import com.sandip.spring.hibernatejpa.hibernatejpa.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class HibernatejpaApplication implements CommandLineRunner {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(HibernatejpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        logger.info("Find By Id -> {}", courseRepository.findById(10002L));
//        courseRepository.deleteById(10002);
//        logger.info("Find By Id -> {}", courseRepository.findById(10002L));
//        courseRepository.save(new Course("JDBC"));
//        courseRepository.playWithEntityManager();
//
//        studentRepository.saveStudentWithPassport();
//        List<Review> reviews = Arrays.asList(new Review[]{new Review("Wondefull Course", "5")
//                            , new Review("Best Course", "4.9")});
//        courseRepository.addReviewsForCourse(10001L, reviews);
//        List<Course> courses = Arrays.asList(new Course[]{new Course("Eureka")
//                            , new Course("Microservices")});
//        List<Student> students = Arrays.asList(new Student[]{new Student("Jai")
//        , new Student("Biru"), new Student("Sanjay")});
//        studentRepository.insertStudentAndCourse("Suraj", courses);
//        studentRepository.insertStudentsAndCourse(students, "DevOPS");

        employeeRepository.saveEmployee(new FullTimeEmployee("Karan", new BigDecimal(4000.89)));
        employeeRepository.saveEmployee(new FullTimeEmployee("Anuj", new BigDecimal(9000)));
        employeeRepository.saveEmployee(new PartTimeEmployee("Abhay", new BigDecimal(400)));
        employeeRepository.getPartTimeEmployees();
        employeeRepository.getFullTimeEmployee();
    }
}
