package com.example.employeeboot.business.impl;

import com.example.employeeboot.business.IDepartmentBusiness;
import com.example.employeeboot.common.Util;
import com.example.employeeboot.dao.DepartmentRepository;
import com.example.employeeboot.domain.Department;
import com.example.employeeboot.dto.DepartmentTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
public class DepartmentBusiness implements IDepartmentBusiness {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    Util util;

    @Override
    public List<DepartmentTO> getDepartments() {
        List<Department> all = departmentRepository.findAll();
        return util.mapList(all, DepartmentTO.class);
    }

    @Override
    public DepartmentTO getDepartment(Long id) {
        return getDepartmentById(id);
    }

    @Override
    public DepartmentTO addDepartment(DepartmentTO department) {
        Department departmentEntity = util.map(department, Department.class);
        Department savedEntity = departmentRepository.save(departmentEntity);
        return util.map(savedEntity, DepartmentTO.class);
    }

    @Override
    public DepartmentTO setDepartment(Long id, DepartmentTO department) {
        Department departmentEntity = util.map(department, Department.class);
        departmentEntity.setId(id);
        departmentRepository.save(departmentEntity);
        return department;
    }

    @Override
    public DepartmentTO deleteDepartment(Long id) {
        DepartmentTO department = getDepartmentById(id);
        departmentRepository.deleteById(id);
        return department;
    }

    private DepartmentTO getDepartmentById(Long id) {
        Optional<Department> byId = departmentRepository.findById(id);
        DepartmentTO departmentTO;
        if (byId.isPresent()) {
            departmentTO = util.map(byId.get(), DepartmentTO.class);
        } else {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find the department of id: " + id);
        }
        return departmentTO;
    }


}
