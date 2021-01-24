package com.example.employeeboot.controller;

import java.util.List;

import com.example.employeeboot.config.BeanConfig;
import com.example.employeeboot.dao.EmployeeRepository;
import com.example.employeeboot.domain.Employee;
import com.example.employeeboot.dto.EmployeeTO;
import com.example.employeeboot.service.IEmployeeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
@Api(tags = {BeanConfig.EMPLOYEE_TAG})
@CrossOrigin
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping()
    @ApiOperation(value = "Returns the list of all available employees")
    public List<EmployeeTO> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/byEmployeeId")
    @ApiOperation(value = "Returns the value of one employee for the given Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The employee has been successfully fetched"),
            @ApiResponse(code = 404, message = "The employee of given id was not found")})
    public EmployeeTO getEmployee(@ApiParam(value = "The employee id", required = true, example = "1001")
    							@RequestParam(name = "id") Long id) {
        return employeeService.getEmployee(id);
    }
    
    @GetMapping("/byDepartmentId")
    @ApiOperation(value = "Returns the value of one employee for the given Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The employee has been successfully fetched"),
            @ApiResponse(code = 404, message = "The employee of given id was not found")})
    public List<EmployeeTO> getEmployeesByDeptId(@ApiParam(value = "The department id", required = true, example = "1001")
    											@RequestParam(name = "id") Long id) {
      return employeeService.getEmployeeByDepartment(id);
    }

    @PostMapping()
    @ApiOperation(value = "Saves the details of the given employee")
    public EmployeeTO addEmployee(@RequestBody EmployeeTO employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "saves the details of the employee for the given id")
    public EmployeeTO setEmployee(@ApiParam(value = "The employee id", required = true, example = "1001")
    		@PathVariable("id") Long id, @RequestBody EmployeeTO employee) {
        return employeeService.setEmployee(id, employee);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Deletes the details of the employee of the given Id")
    public EmployeeTO deleteEmployee(@ApiParam(value = "The employee id", required = true, example = "1001")
    								@PathVariable("id") Long id) {
        return employeeService.deleteEmployee(id);
    }

}
