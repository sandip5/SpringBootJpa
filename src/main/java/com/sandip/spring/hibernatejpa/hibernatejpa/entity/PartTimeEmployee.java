package com.sandip.spring.hibernatejpa.hibernatejpa.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class PartTimeEmployee extends Employee{
    private BigDecimal partTimeEmployeeWage;
    protected PartTimeEmployee() {}

    public PartTimeEmployee(String name, BigDecimal partTimeEmployeeWage) {
        super(name);
        this.partTimeEmployeeWage = partTimeEmployeeWage;
    }
}
