package com.avtech.springcloud.springcloudstreamproducer.producer;

import com.avtech.springcloud.springcloudstreamproducer.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class EmployeeProducer {

    @Autowired
    private MessageChannel output;

    public Employee publishEmployee(Employee employee){
        output.send(MessageBuilder.withPayload(employee).build());
        return employee;
    }
}
