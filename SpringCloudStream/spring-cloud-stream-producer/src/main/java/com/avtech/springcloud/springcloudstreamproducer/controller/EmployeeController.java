package com.avtech.springcloud.springcloudstreamproducer.controller;

import com.avtech.springcloud.springcloudstreamproducer.model.Employee;
import com.avtech.springcloud.springcloudstreamproducer.producer.EmployeeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeProducer employeeProducer;

    @PostMapping(value = "/add-employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeProducer.publishEmployee(employee);
    }
}
