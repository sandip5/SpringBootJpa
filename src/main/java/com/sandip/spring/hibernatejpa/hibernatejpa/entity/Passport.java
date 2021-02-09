package com.sandip.spring.hibernatejpa.hibernatejpa.entity;

import javax.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String number;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

    public Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "\nPassport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
