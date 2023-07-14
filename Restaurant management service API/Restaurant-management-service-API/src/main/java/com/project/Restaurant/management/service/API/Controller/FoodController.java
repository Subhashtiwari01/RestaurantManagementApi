package com.project.Restaurant.management.service.API.Controller;

import com.project.Restaurant.management.service.API.Model.AuthenticationToken;
import com.project.Restaurant.management.service.API.Model.Food;
import com.project.Restaurant.management.service.API.Model.Type;
import com.project.Restaurant.management.service.API.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;



    @PostMapping("createFood")

    public String addFood(@RequestBody Food food, Type Admin, @PathVariable String token){
        return foodService.addFood(food,Admin,token);
    }
    @GetMapping("getFood")

    public Iterable<Food> getAllFood(){
        return foodService.getAllFood();
    }

}
