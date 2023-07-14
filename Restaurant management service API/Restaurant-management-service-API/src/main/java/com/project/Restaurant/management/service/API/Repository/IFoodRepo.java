package com.project.Restaurant.management.service.API.Repository;

import com.project.Restaurant.management.service.API.Model.Food;
import com.project.Restaurant.management.service.API.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodRepo extends JpaRepository<Food,Long> {
}
