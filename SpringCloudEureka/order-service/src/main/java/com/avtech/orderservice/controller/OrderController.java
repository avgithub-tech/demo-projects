package com.avtech.orderservice.controller;

import com.avtech.orderservice.model.Order;
import com.avtech.orderservice.model.Payment;
import com.avtech.orderservice.model.TransactionRequest;
import com.avtech.orderservice.model.TransactionResponse;
import com.avtech.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/book-order")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){
        return orderService.saveOrder(request);
    }

}
