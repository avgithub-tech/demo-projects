package com.avtech.paymentservice.service;

import com.avtech.paymentservice.model.Payment;
import com.avtech.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    public Payment doPayment(@RequestBody Payment payment){
        payment.setPaymentStatus(processPayment());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }


    public String processPayment(){
        return new Random().nextBoolean()?"SUCCESS":"FAILED";
    }

}
