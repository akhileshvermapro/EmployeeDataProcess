package com.example.employee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
