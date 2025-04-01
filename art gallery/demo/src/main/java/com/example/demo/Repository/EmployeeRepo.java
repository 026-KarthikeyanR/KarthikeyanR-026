package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {


    // // Derived query method
    // Employee findByEmployeeName(String employeeName);

    // // Case-insensitive search using JPQL
    @Query("SELECT e FROM Employee e WHERE LOWER(e.employeeName) = LOWER(:employeeName)")
    List<Employee> findByE(@Param("employeeName") String employeeName);

    // // Find employees by department
    // List<Employee> findByDepartment(String department);
}
