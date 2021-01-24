package com.example.employeeboot.service;

import com.example.employeeboot.dto.EmployeeTO;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeTO> getEmployees();

    EmployeeTO getEmployee(Long id);

    EmployeeTO addEmployee(EmployeeTO employee);

    EmployeeTO setEmployee(Long id, EmployeeTO employee);

    EmployeeTO deleteEmployee(Long id);
    
    List<EmployeeTO> getEmployeeByDepartment(Long id);
}
