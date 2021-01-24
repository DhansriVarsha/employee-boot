package com.example.employeeboot.service.impl;

import com.example.employeeboot.business.IPhoneBusiness;
import com.example.employeeboot.dto.PhoneTO;
import com.example.employeeboot.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PhoneService implements IPhoneService {

    @Autowired
    IPhoneBusiness phoneBusiness;

    @Override
    public List<PhoneTO> getPhones() {
        return phoneBusiness.getPhones();
    }

    @Override
    public PhoneTO getPhone(Long id) {
        return phoneBusiness.getPhone(id);
    }

    @Override
    @Transactional
    public PhoneTO addPhone(PhoneTO phone) {
        return phoneBusiness.addPhone(phone);
    }

    @Override
    @Transactional
    public PhoneTO setPhone(Long id, PhoneTO phone) {
        return phoneBusiness.setPhone(id, phone);
    }

    @Override
    @Transactional
    public PhoneTO deletePhone(Long id) {
        return phoneBusiness.deletePhone(id);
    }

}
