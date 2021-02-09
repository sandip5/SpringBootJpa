package com.sandip.spring.hibernatejpa.hibernatejpa.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class FullTimeEmployee extends Employee{
    private BigDecimal fullTimeEmployeeWage;
    protected FullTimeEmployee() {}

    public FullTimeEmployee(String name, BigDecimal fullTimeEmployeeWage) {
        super(name);
        this.fullTimeEmployeeWage = fullTimeEmployeeWage;
    }
}
