package com.example.employeeboot.service.impl;

import com.example.employeeboot.business.IEmployeeBusiness;
import com.example.employeeboot.dto.EmployeeTO;
import com.example.employeeboot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeBusiness employeeBusiness;

    @Override
    public List<EmployeeTO> getEmployees() {
        return employeeBusiness.getEmployees();
    }

    @Override
    public EmployeeTO getEmployee(Long id) {
        return employeeBusiness.getEmployee(id);
    }

    @Override
    @Transactional
    public EmployeeTO addEmployee(EmployeeTO employee) {
        return employeeBusiness.addEmployee(employee);
    }

    @Override
    @Transactional
    public EmployeeTO setEmployee(Long id, EmployeeTO employee) {
        return employeeBusiness.setEmployee(id, employee);
    }

    @Override
    @Transactional
    public EmployeeTO deleteEmployee(Long id) {
        return employeeBusiness.deleteEmployee(id);
    }

	@Override
	@Transactional
	public List<EmployeeTO> getEmployeeByDepartment(Long id) {
		return employeeBusiness.getEmployeeByDepartment(id);
	}
    
    

}
