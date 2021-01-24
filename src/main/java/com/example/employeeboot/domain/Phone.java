package com.example.employeeboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "PHONE")
public class Phone {
	@Id
    @GeneratedValue(generator = "phone_generator")
    @SequenceGenerator(
            name = "phone_generator",
            sequenceName = "phone_sequence",
            initialValue = 1000
    )
    private Long id;
	
	@Column()
	private String[] number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String[] getNumber() {
		return number;
	}

	public void setNumber(String[] number) {
		this.number = number;
	}
	
	
}
