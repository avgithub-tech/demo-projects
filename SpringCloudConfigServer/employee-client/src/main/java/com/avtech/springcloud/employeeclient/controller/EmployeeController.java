package com.avtech.springcloud.employeeclient.controller;


import com.avtech.springcloud.employeeclient.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/employee-service")
public class EmployeeController {

    @Value("${employee.service.url}")
    private String url;

    @Autowired
    private RestTemplate template;

    @GetMapping("/get-employees")
    public List<Employee> getAllEmployees(){
        List<Employee> employees = template.getForObject(url,List.class);
        return employees;
    }

    @Bean
    public RestTemplate template(){
        return new RestTemplate();
    }
}
