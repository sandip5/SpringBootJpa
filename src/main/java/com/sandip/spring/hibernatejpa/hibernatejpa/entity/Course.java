package com.sandip.spring.hibernatejpa.hibernatejpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries(
        value = {
                @NamedQuery(name = "query_get_all_courses", query = "Select  c  From Course c"),
                @NamedQuery(name = "query_get_100_Step_courses", query = "Select  c  From Course c where name like '%100 steps'")
        }
)
//@Table(name="course_details")
//@Cacheable
//@Transactional
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    private boolean isDeleted;

    @OneToMany(mappedBy = "course")
    private List<Review> reviewList = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> students = new ArrayList<>();

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Review> addReview(Review review) {
        reviewList.add(review);
        return reviewList;
    }

    public List<Review> removeReview(Review review) {
        reviewList.remove(review);
        return reviewList;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return String.format("Courses[%s]", name);
    }
}
