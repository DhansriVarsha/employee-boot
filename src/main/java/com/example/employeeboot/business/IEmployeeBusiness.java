package com.example.employeeboot.business;

import java.util.List;

import com.example.employeeboot.dto.EmployeeTO;

public interface IEmployeeBusiness {

    List<EmployeeTO> getEmployees();

    EmployeeTO getEmployee(Long id);

    EmployeeTO addEmployee(EmployeeTO employee);

    EmployeeTO setEmployee(Long id, EmployeeTO employee);

    EmployeeTO deleteEmployee(Long id);
    
    List<EmployeeTO> getEmployeeByDepartment(Long id);

}
