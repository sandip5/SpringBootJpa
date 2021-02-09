package com.sandip.spring.hibernatejpa.hibernatejpa.repository;

import com.sandip.spring.hibernatejpa.hibernatejpa.entity.Employee;
import com.sandip.spring.hibernatejpa.hibernatejpa.entity.FullTimeEmployee;
import com.sandip.spring.hibernatejpa.hibernatejpa.entity.PartTimeEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
    @Autowired
    EntityManager em;

    public void saveEmployee(Employee employee) {
        em.persist(employee);
    }

    public List<FullTimeEmployee> getFullTimeEmployee() {
        return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
    }

    public List<PartTimeEmployee> getPartTimeEmployees() {
        return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
    }
}
