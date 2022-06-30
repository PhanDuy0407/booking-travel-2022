package com.group10.bookingtravel.service;

import com.group10.bookingtravel.entity.Orders;
import com.group10.bookingtravel.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> getAllOrders(){
        List<Orders> ordersList = new ArrayList<>();
        if(ordersRepository.listAllOrders().isPresent()){
            return ordersRepository.listAllOrders().get();
        }
        return ordersList;
    }
}
