package com.example.employeeboot.service;

import com.example.employeeboot.dto.PhoneTO;

import java.util.List;

public interface IPhoneService {
    List<PhoneTO> getPhones();

    PhoneTO getPhone(Long id);

    PhoneTO addPhone(PhoneTO phone);

    PhoneTO setPhone(Long id, PhoneTO phone);

    PhoneTO deletePhone(Long id);
}
