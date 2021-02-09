package com.sandip.spring.hibernatejpa.hibernatejpa.repository;

import com.sandip.spring.hibernatejpa.hibernatejpa.HibernatejpaApplication;
import com.sandip.spring.hibernatejpa.hibernatejpa.entity.Course;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernatejpaApplication.class)
public class CourseRepositoryTest {
    @Autowired
    CourseRepository repo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void contextLoads() {
        logger.info("Test is running");
        Assert.assertEquals("java", repo.findById(10001).getName());
    }

    @Test
    @DirtiesContext
    public void deleteMethodTest() {
        repo.deleteById(10001);
        Assert.assertNull(repo.findById(10001));
    }

    @Test
    public void saveMethodTest() {
        repo.save(new Course("Hibernate"));
        Course course = repo.findById(10001L);
        course.setName("Java 8");
        repo.save(course);
        Assert.assertEquals("Java 8", repo.findById(10001L).getName());
    }

    @Test
    @DirtiesContext
    public void playWithEntityManager() {
        repo.playWithEntityManager();
    }

    @Test
    @Transactional
    public void retrieveReviewForCourse() {
        Course course = repo.findById(10001L);
        logger.info("{}", course.getReviewList());
    }

}
