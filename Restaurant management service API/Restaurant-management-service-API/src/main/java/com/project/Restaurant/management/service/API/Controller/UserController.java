package com.project.Restaurant.management.service.API.Controller;

import com.project.Restaurant.management.service.API.Model.DataObject.SignInInput;
import com.project.Restaurant.management.service.API.Model.DataObject.SignupOutput;
import com.project.Restaurant.management.service.API.Model.User;
import com.project.Restaurant.management.service.API.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("adduser/userSignup")
    public SignupOutput userSignup(@RequestBody User user) throws NoSuchAlgorithmException {
         return userService.userSignup(user);
    }


    @PostMapping("user/userSigIn")
    public String userSigIn(@RequestBody @Valid SignInInput signInInput) throws NoSuchAlgorithmException {
        return userService.userSigIn(signInInput);
    }



    @GetMapping("user")
    public Iterable<User> getAllUser(){
        return userService.findAll();
    }
    @DeleteMapping("deleteUser")

    public String deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }


    @PutMapping("updateuser")

    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

}
