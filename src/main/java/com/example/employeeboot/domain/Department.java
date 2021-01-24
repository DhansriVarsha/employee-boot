package com.example.employeeboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
public class Department {
	
	@Id
    @GeneratedValue(generator = "department_generator")
    @SequenceGenerator(
            name = "department_generator",
            sequenceName = "department_sequence",
            initialValue = 1000
    )
    private Long id;
	
	@Column()
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
