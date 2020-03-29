package com.avtech.orderservice.service;

import com.avtech.orderservice.model.Order;
import com.avtech.orderservice.model.Payment;
import com.avtech.orderservice.model.TransactionRequest;
import com.avtech.orderservice.model.TransactionResponse;
import com.avtech.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;


    public TransactionResponse saveOrder(TransactionRequest request){

        TransactionResponse response = new TransactionResponse();
        Order order = request.getOrder();

        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        Payment paymentResponse = restTemplate.postForObject("http://payment-service/payment-service/do-payment",payment,Payment.class);

        if("SUCCESS".equalsIgnoreCase(paymentResponse.getPaymentStatus())){
            response.setMessage("Payment processing was successful");
        }
        else{
            response.setMessage("Payment processing was failed");
        }
        response.setOrderId(paymentResponse.getOrderId());
        response.setAmount(paymentResponse.getAmount());

        orderRepository.save(order);

        return response;
    }
}
