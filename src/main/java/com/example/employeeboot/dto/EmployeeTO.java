package com.example.employeeboot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Employee object")
public class EmployeeTO {

    @ApiModelProperty(notes = "Unique identifier of the employee.", example = "1000", required = true, position = 0)
    private Long id;

    @ApiModelProperty(notes = "Name of the employee.", example = "Varsha", required = true, position = 1)
    private String name;

    @ApiModelProperty(notes = "Age of the employee.", example = "23", required = true, position = 2)
    private int age;

    @ApiModelProperty(notes = "Address of the employee.", example = "123 cross street", required = true, position = 3)
    private String address;
    
    @ApiModelProperty(notes = "Department details of the employee.", example = "2000", required = true, position = 4)
    private DepartmentTO department;

    @ApiModelProperty(notes = "Phone numbers of the employee.", example = "3000", required = true, position = 5)
    private PhoneTO phoneList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DepartmentTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentTO department) {
        this.department = department;
    }

    public PhoneTO getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(PhoneTO phone) {
        this.phoneList = phone;
    }


}
