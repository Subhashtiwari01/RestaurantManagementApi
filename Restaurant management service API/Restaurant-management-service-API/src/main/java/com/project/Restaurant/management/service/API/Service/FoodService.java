package com.project.Restaurant.management.service.API.Service;

import com.project.Restaurant.management.service.API.Model.Food;
import com.project.Restaurant.management.service.API.Model.Type;
import com.project.Restaurant.management.service.API.Repository.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired
    IFoodRepo foodRepo;
    public String addFood(Food food, Type admin,String token) {
//        String whichType=foodRepo.save(food);
          foodRepo.save(food);
          return "Food Created";
    }


    public Iterable<Food> getAllFood() {
        return foodRepo.findAll();
    }
}
