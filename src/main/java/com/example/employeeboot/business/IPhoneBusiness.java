package com.example.employeeboot.business;

import com.example.employeeboot.dto.DepartmentTO;
import com.example.employeeboot.dto.PhoneTO;

import java.util.List;

public interface IPhoneBusiness {

    List<PhoneTO> getPhones();

    PhoneTO getPhone(Long id);

    PhoneTO addPhone(PhoneTO phone);

    PhoneTO setPhone(Long id, PhoneTO phone);

    PhoneTO deletePhone(Long id);

}
