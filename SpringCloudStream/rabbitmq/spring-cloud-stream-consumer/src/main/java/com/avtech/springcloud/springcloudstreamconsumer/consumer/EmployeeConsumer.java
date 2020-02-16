package com.avtech.springcloud.springcloudstreamconsumer.consumer;

import com.avtech.springcloud.springcloudstreamconsumer.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class EmployeeConsumer {

    private Logger log = LoggerFactory.getLogger(EmployeeConsumer.class);


    @StreamListener("input")
    public void consumeEmployee(Employee employee){
        log.info("Consume employee: "+employee);
    }

}
