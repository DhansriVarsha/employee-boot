package com.example.employeeboot.service.impl;

import com.example.employeeboot.business.IDepartmentBusiness;
import com.example.employeeboot.dto.DepartmentTO;
import com.example.employeeboot.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    IDepartmentBusiness departmentBusiness;

    @Override
    public List<DepartmentTO> getDepartments() {
        return departmentBusiness.getDepartments();
    }

    @Override
    public DepartmentTO getDepartment(Long id) {
        return departmentBusiness.getDepartment(id);
    }

    @Override
    @Transactional
    public DepartmentTO addDepartment(DepartmentTO department) {
        return departmentBusiness.addDepartment(department);
    }

    @Override
    @Transactional
    public DepartmentTO setDepartment(Long id, DepartmentTO department) {
        return departmentBusiness.setDepartment(id, department);
    }

    @Override
    @Transactional
    public DepartmentTO deleteDepartment(Long id) {
        return departmentBusiness.deleteDepartment(id);
    }

}
