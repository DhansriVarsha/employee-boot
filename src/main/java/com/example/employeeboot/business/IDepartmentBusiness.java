package com.example.employeeboot.business;

import com.example.employeeboot.dto.DepartmentTO;

import java.util.List;

public interface IDepartmentBusiness {

    List<DepartmentTO> getDepartments();

    DepartmentTO getDepartment(Long id);

    DepartmentTO addDepartment(DepartmentTO department);

    DepartmentTO setDepartment(Long id, DepartmentTO department);

    DepartmentTO deleteDepartment(Long id);

}
