package com.sandip.spring.hibernatejpa.hibernatejpa.repository;

import com.sandip.spring.hibernatejpa.hibernatejpa.entity.Course;
import com.sandip.spring.hibernatejpa.hibernatejpa.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(int id) {
        em.remove(findById(id));
    }

    public Course save(Course course) {
        if(course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    public void playWithEntityManager() {
        logger.info("Play With Entity Manager");
        Course course1 = new Course("JSP");
        em.persist(course1);
        Course course2 = new Course("SERVLET");
        em.persist(course2);
//        em.detach(course1);
        em.flush();
//        em.clear();
        course1.setName("Updated JSP");
        em.clear();
        course2.setName("Updated Servlet");
        em.flush();

        Course course3 = new Course("Microservices");
        em.persist(course3);
        course3.setName("Microservices - Updated");
        Course course4 = findById(1);
        course4.setName("JDBC - Updated");

    }

    public void addReviewsForCourse() {
        Course course = findById(10001L);
        logger.info("Course -> {}", course);
        logger.info("Review List -> {}", course.getReviewList());
        Review review1 = new Review("Best Course", "4.5");
        Review review2 = new Review("Great Course", "4.8");
        course.addReview(review1);
        review1.setCourse(course);
        course.addReview(review2);
        review2.setCourse(course);
        em.persist(review1);
        em.persist(review2);
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);
        logger.info("Course -> {}", course);
        logger.info("Review List -> {}", course.getReviewList());
        for (Review review : reviews) {
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }

    }
}
