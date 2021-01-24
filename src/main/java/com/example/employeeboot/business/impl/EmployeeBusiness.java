package com.example.employeeboot.business.impl;

import com.example.employeeboot.business.IEmployeeBusiness;
import com.example.employeeboot.common.Util;
import com.example.employeeboot.dao.DepartmentRepository;
import com.example.employeeboot.dao.EmployeeRepository;
import com.example.employeeboot.dao.PhoneRepository;
import com.example.employeeboot.domain.Employee;
import com.example.employeeboot.dto.EmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
public class EmployeeBusiness implements IEmployeeBusiness {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    PhoneRepository phoneRepository;

    @Autowired
    Util util;

    @Override
    public List<EmployeeTO> getEmployees() {
        List<Employee> all = employeeRepository.findAll();
        return util.mapList(all, EmployeeTO.class);
    }

    @Override
    public EmployeeTO getEmployee(Long id) {
        return getEmployeeById(id);
    }

    @Override
    public EmployeeTO addEmployee(EmployeeTO employee) {
        Employee employeeEntity = util.map(employee, Employee.class);
        Employee savedEntity = employeeRepository.save(employeeEntity);
        return util.map(savedEntity, EmployeeTO.class);
    }

    @Override
    public EmployeeTO setEmployee(Long id, EmployeeTO employee) {
        Employee employeeEntity = util.map(employee, Employee.class);
        employeeEntity.setId(id);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public EmployeeTO deleteEmployee(Long id) {
        EmployeeTO employee = getEmployeeById(id);
        employeeRepository.deleteById(id);
        return employee;
    }
    
    @Override
    public List<EmployeeTO> getEmployeeByDepartment(Long id){
    	List<Employee> all = employeeRepository.getEmployeeByDepartment(id);
        List<EmployeeTO> employeeTOs;
        if (!all.isEmpty()) {
            employeeTOs = util.mapList(all, EmployeeTO.class);
        } else {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find the employee for the dept id: " + id);
        }
        return employeeTOs;
    }

    private EmployeeTO getEmployeeById(Long id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        EmployeeTO employeeTO;
        if (byId.isPresent()) {
            employeeTO = util.map(byId.get(), EmployeeTO.class);
        } else {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find the employee of id: " + id);
        }
        return employeeTO;
    }


}
