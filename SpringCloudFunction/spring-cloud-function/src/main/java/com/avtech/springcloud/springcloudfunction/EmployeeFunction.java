package com.avtech.springcloud.springcloudfunction;

import java.util.function.Function;

public class EmployeeFunction implements Function<String,Employee> {

    @Override
    public Employee apply(String name) {
        return new Employee(1,name);
    }
}
