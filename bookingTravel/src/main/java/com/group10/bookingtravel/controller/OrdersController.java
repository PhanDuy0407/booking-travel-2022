package com.group10.bookingtravel.controller;

import com.group10.bookingtravel.entity.Orders;
import com.group10.bookingtravel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class OrdersController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders-all")
    public List<Orders> getAllOrders(){
        return orderService.getAllOrders();
    }
}
