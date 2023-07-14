package com.project.Restaurant.management.service.API.Service;

import com.project.Restaurant.management.service.API.Model.Order;
import com.project.Restaurant.management.service.API.Model.Type;
import com.project.Restaurant.management.service.API.Repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;
    public void createOrder(Order order, Type User) {
         orderRepo.save(order);
    }

    public Iterable<Order> getOrderDetail() {
        return orderRepo.findAll();
    }
}
