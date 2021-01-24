package com.example.employeeboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeeboot.domain.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long>{

}
