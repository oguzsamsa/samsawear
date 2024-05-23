package com.workintech.samsawear.controller;

import com.workintech.samsawear.entity.User;
import com.workintech.samsawear.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
}
