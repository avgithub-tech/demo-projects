package com.avtech.springcloud.employeeclient.controller;


import com.avtech.springcloud.employeeclient.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class EmployeeController {

    @Value("${employee.service.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get-employees")
    public List<Employee> getAllEmployees(){
        List<Employee> employees = restTemplate.getForObject(url,List.class);
        return employees;
    }
}
