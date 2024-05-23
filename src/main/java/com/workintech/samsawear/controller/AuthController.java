package com.workintech.samsawear.controller;

import com.workintech.samsawear.dto.RegistrationResponse;
import com.workintech.samsawear.dto.RegistrationUser;
import com.workintech.samsawear.entity.User;
import com.workintech.samsawear.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public RegistrationResponse register(@RequestBody RegistrationUser registrationUser){
        User createdUser = authenticationService.register(registrationUser.name(), registrationUser.email(), registrationUser.password());
        return new RegistrationResponse(createdUser.getEmail(), "Registration successful!");
    }

    @PostMapping("/login")
    public RegistrationResponse login(@RequestBody RegistrationUser loginUser){
        User loggedUser = authenticationService.login(loginUser.email(), loginUser.password());
        return new RegistrationResponse(loggedUser.getEmail(), "Login successful!");
    }
}
