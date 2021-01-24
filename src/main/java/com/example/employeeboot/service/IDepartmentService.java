package com.example.employeeboot.service;

import com.example.employeeboot.dto.DepartmentTO;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentTO> getDepartments();

    DepartmentTO getDepartment(Long id);

    DepartmentTO addDepartment(DepartmentTO department);

    DepartmentTO setDepartment(Long id, DepartmentTO department);

    DepartmentTO deleteDepartment(Long id);
}
