package com.project.Restaurant.management.service.API.Controller;

import com.project.Restaurant.management.service.API.Model.Order;
import com.project.Restaurant.management.service.API.Model.Type;
import com.project.Restaurant.management.service.API.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;



    @PostMapping("createOrder")

    public void createOrder(@RequestBody Order order,Type User){
         orderService.createOrder(order,User);
    }
    @GetMapping("order")

    public Iterable<Order> getOrderDetail(){
        return orderService.getOrderDetail();
    }
}
