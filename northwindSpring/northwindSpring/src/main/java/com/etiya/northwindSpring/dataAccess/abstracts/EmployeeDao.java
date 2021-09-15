package com.etiya.northwindSpring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.northwindSpring.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
