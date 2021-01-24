package com.example.employeeboot.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.employeeboot.dao.EmployeeRepository;
import com.example.employeeboot.domain.Department;
import com.example.employeeboot.domain.Employee;
import com.example.employeeboot.domain.Phone;

@Component
public class DataLoader {

	public static final List<String> NAME_LIST = Arrays.asList("Pooja V", "Ram Kumar E", "Palaniswani B", "Suran Raj",
			"Sreeja", "Kadhar", "Sankar G", "Gokul", "Mohana", "Ramesh");
	public static final List<Integer> AGE_LIST = Arrays.asList(22, 23, 24, 25, 26, 27, 20, 28, 25, 30);
	public static final List<String> ADDRESS_LIST = Arrays.asList("No: 1223, 12th cross st",
			"No: 43/12, Kannapan nagar", "SB Illam, Ganesan road", "No: 3/21, Santhome Rd.",
			"No: 93/123, Maniyakaranpalayam", "Vels house, OMR Road", "No: 2/12, Annur", "No: 4/765, Neru nagar",
			"No: 74, Wellesly st.", "WA Illam, Joka");
	public static final List<String> DEPARTMENT_LIST = Arrays.asList("department-1", "department-2", "department-3",
			"department-4", "department-5", "department-6", "department-7", "department-8", "department-9",
			"department-10");
	public static final List<List<String>> PHONE_LIST = Arrays.asList(Arrays.asList("9887483747"),
			Arrays.asList("7865479238"), Arrays.asList("4567454364", "9561623411"), Arrays.asList("3253476589"),
			Arrays.asList("9864537265", "9090931256"), Arrays.asList("9974133111", "7896784212", "9956451321"),
			Arrays.asList("8932122135"), Arrays.asList("9090874635"), Arrays.asList("9876766567"),
			Arrays.asList("9183742211", "9984739237", "8955454342", "9864746212"));

	@Autowired
	EmployeeRepository employeeRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void appReady() {
		loadEmployees();
	}

	public void loadEmployees() {
		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < NAME_LIST.size(); i++) {
			Employee employee = new Employee();
			employee.setName(NAME_LIST.get(i));
			employee.setAge(AGE_LIST.get(i));
			employee.setAddress(ADDRESS_LIST.get(i));

			Department dept1 = new Department();
			dept1.setName(DEPARTMENT_LIST.get(i));
			employee.setDepartment(dept1);

			Phone phone1 = new Phone();
			phone1.setNumber((String[]) PHONE_LIST.get(i).toArray());
			employee.setPhoneList(phone1);
			employees.add(employee);
			employeeRepository.saveAll(employees);
		}

	}

}
