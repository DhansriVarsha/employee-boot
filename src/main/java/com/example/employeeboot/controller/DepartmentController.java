package com.example.employeeboot.controller;

import com.example.employeeboot.config.BeanConfig;
import com.example.employeeboot.dto.DepartmentTO;
import com.example.employeeboot.dto.EmployeeTO;
import com.example.employeeboot.service.IDepartmentService;
import com.example.employeeboot.service.IEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
@Api(tags = {BeanConfig.DEPARTMENT_TAG})
@CrossOrigin
public class DepartmentController {

    @Autowired
    IDepartmentService departmentService;

    @GetMapping()
    @ApiOperation(value = "Returns the list of all available departments")
    public List<DepartmentTO> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Returns the value of one department for the given Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The department has been successfully fetched"),
            @ApiResponse(code = 404, message = "The department of given id was not found")})
    public DepartmentTO getDepartment(@ApiParam(value = "The department id", required = true, example = "2001")
    								@PathVariable("id") Long id) {
        return departmentService.getDepartment(id);
    }

    @PostMapping()
    @ApiOperation(value = "Saves the details of the given department")
    public DepartmentTO addDepartment(@RequestBody DepartmentTO employee) {
        return departmentService.addDepartment(employee);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Saves the details of the department for the given id")
    public DepartmentTO setDepartment(@ApiParam(value = "The department id", required = true, example = "2001")
    								  @PathVariable("id") Long id, @RequestBody DepartmentTO employee) {
        return departmentService.setDepartment(id, employee);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Deletes the details of the department of the given Id")
    public DepartmentTO deleteDepartment(@ApiParam(value = "The department id", required = true, example = "2001")
    									 @PathVariable("id") Long id) {
        return departmentService.deleteDepartment(id);
    }

}
