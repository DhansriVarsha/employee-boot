package com.example.employeeboot.business.impl;

import com.example.employeeboot.business.IPhoneBusiness;
import com.example.employeeboot.common.Util;
import com.example.employeeboot.dao.PhoneRepository;
import com.example.employeeboot.domain.Phone;
import com.example.employeeboot.dto.PhoneTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
public class PhoneBusiness implements IPhoneBusiness {


    @Autowired
    PhoneRepository phoneRepository;

    @Autowired
    Util util;

    @Override
    public List<PhoneTO> getPhones() {
        List<Phone> all = phoneRepository.findAll();

        return util.mapList(all, PhoneTO.class);
    }

    @Override
    public PhoneTO getPhone(Long id) {
        return getPhoneById(id);
    }

    @Override
    public PhoneTO addPhone(PhoneTO phone) {
        Phone PhoneEntity = util.map(phone, Phone.class);
        Phone savedEntity = phoneRepository.save(PhoneEntity);
        return util.map(savedEntity, PhoneTO.class);
    }

    @Override
    public PhoneTO setPhone(Long id, PhoneTO phone) {
        Phone phoneEntity = util.map(phone, Phone.class);
        phoneEntity.setId(id);
        phoneRepository.save(phoneEntity);
        return phone;
    }

    @Override
    public PhoneTO deletePhone(Long id) {
        PhoneTO phone = getPhoneById(id);
        phoneRepository.deleteById(id);
        return phone;
    }

    private PhoneTO getPhoneById(Long id) {
        Optional<Phone> byId = phoneRepository.findById(id);
        PhoneTO phoneTO;
        if (byId.isPresent()) {
            phoneTO = util.map(byId.get(), PhoneTO.class);
        } else {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find the phone of id: " + id);
        }
        return phoneTO;
    }


}
