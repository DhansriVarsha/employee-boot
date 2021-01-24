package com.example.employeeboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.employeeboot.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query("select e from Employee e where e.department.id = :departmentId order by e.age")
	List<Employee> getEmployeeByDepartment(@Param("departmentId") Long departmentId);
	
}
