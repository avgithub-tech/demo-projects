package com.avtech.springcloud.employeeservice.controller;

import com.avtech.springcloud.employeeservice.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/employee-service")
public class EmployeeController {

    @GetMapping("/get-all-employees")
    public List<Employee> getAllEmployees(){
        return Stream.of(new Employee(1,"Amit","Mumbai"),
                new Employee(2,"Hiral","Ahmedabad"),
                new Employee(3,"Darsh","Mumbai")).collect(Collectors.toList());
    }
}
