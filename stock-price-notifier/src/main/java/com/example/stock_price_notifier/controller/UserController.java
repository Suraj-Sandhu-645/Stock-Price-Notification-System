package com.example.stock_price_notifier.controller;

import com.example.stock_price_notifier.dto.UserDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/")
public class UserController {

    @PostMapping("register")
    public void registerUser(@RequestBody @Validated UserDTO userDTO){

    }
}
