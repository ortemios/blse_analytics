package com.itmo.blse.controller;

import com.itmo.blse.model.User;
import com.itmo.blse.repository.UserRepository;
import com.itmo.blse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users/me/", produces = "application/json")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String me() {
        return userService.fromContext().getUsername();

    }


}
