package com.example.employeeboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeeboot.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
