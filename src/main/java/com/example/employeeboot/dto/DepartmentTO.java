package com.example.employeeboot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Department object")
public class DepartmentTO {
	
	@ApiModelProperty(notes = "Unique identifier of the department.", example = "2000", required = true, position = 0)
    private Long id;
	
	@ApiModelProperty(notes = "Name of the department.", example = "HR", required = true, position = 1)
	private String name;

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
	
	

}
