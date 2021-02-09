package com.sandip.spring.hibernatejpa.hibernatejpa.repository;

import com.sandip.spring.hibernatejpa.hibernatejpa.HibernatejpaApplication;
import com.sandip.spring.hibernatejpa.hibernatejpa.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernatejpaApplication.class)
public class CourseDataRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @Test
    public void findById_CoursePresent() {
        Optional<Course> courseOptional = repository.findById(10001L);
        assertTrue(courseOptional.isPresent());
    }

    @Test
    public void findById_CourseNotPresent() {
        Optional<Course> courseOptional = repository.findById(20001L);
        assertFalse(courseOptional.isPresent());
    }

    @Test
    public void playingAroundWithSpringDataRepository() {
        //Course course = new Course("Microservices in 100 Steps");
        //repository.save(course);

        //course.setName("Microservices in 100 Steps - Updated");
        //repository.save(course);
        logger.info("Courses -> {} ", repository.findAll());
        logger.info("Count -> {} ", repository.count());
    }

    @Test
    public void sort() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        logger.info("Sorted Courses -> {} ", repository.findAll(sort));
        //Courses -> [Course[JPA in 50 Steps], Course[Spring in 50 Steps], Course[Spring Boot in 100 Steps]]
    }

    @Test
    public void pagination() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Course> firstPage = repository.findAll(pageRequest);
        logger.info("First Page -> {} ", firstPage.getContent());

        Pageable secondPageable = firstPage.nextPageable();
        Page<Course> secondPage = repository.findAll(secondPageable);
        logger.info("Second Page -> {} ", secondPage.getContent());
    }

    @Test
    public void findUsingName() {
        logger.info("FindByName -> {} ", repository.findByName("Microservices"));
    }

    @Test
    public void findUsingStudentsName() {
        logger.info("findUsingStudentsName -> {} ", repository.findByName("Sandip"));
    }

}
