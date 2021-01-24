package com.example.employeeboot.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Phone object")
public class PhoneTO {
	
	@ApiModelProperty(notes = "Unique identifier of the phone.", example = "3000", required = true, position = 0)
    private Long id;
	
	@ApiModelProperty(notes = "list of phone numbers of the employee.", example = "['9986428758','9345678321']", required = true, position = 1)
	private List<String> number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getNumber() {
		return number;
	}

	public void setNumber(List<String> number) {
		this.number = number;
	}
	
	
}
