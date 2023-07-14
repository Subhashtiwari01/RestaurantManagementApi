package com.project.Restaurant.management.service.API.Repository;

import com.project.Restaurant.management.service.API.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order,Long> {
}
