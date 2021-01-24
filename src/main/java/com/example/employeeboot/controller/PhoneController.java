package com.example.employeeboot.controller;

import com.example.employeeboot.config.BeanConfig;
import com.example.employeeboot.dto.PhoneTO;
import com.example.employeeboot.service.IPhoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/phone")
@Api(tags = {BeanConfig.PHONE_TAG})
@CrossOrigin
public class PhoneController {

    @Autowired
    IPhoneService phoneService;

    @GetMapping()
    @ApiOperation(value = "Returns the list of all available phone details")
    public List<PhoneTO> getPhones() {
        return phoneService.getPhones();
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Returns the value of phone details for the given Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The phone details has been successfully fetched"),
            @ApiResponse(code = 404, message = "The phone details of given id was not found")})
    public PhoneTO getPhone(@ApiParam(value = "The phone id", required = true, example = "3001")
    						@PathVariable("id") Long id) {
        return phoneService.getPhone(id);
    }

    @PostMapping()
    @ApiOperation(value = "Saves the details of the given phone object")
    public PhoneTO addPhone(@RequestBody PhoneTO employee) {
        return phoneService.addPhone(employee);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Saves the phone details for the given id")
    public PhoneTO setPhone(@ApiParam(value = "The phone id", required = true, example = "3001")
    						@PathVariable("id") Long id, @RequestBody PhoneTO employee) {
        return phoneService.setPhone(id, employee);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Deletes the phone details of the given Id")
    public PhoneTO deletePhone(@ApiParam(value = "The phone id", required = true, example = "3001")
    						   @PathVariable("id") Long id) {
        return phoneService.deletePhone(id);
    }

}
