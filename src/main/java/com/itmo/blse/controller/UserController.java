package com.itmo.blse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users/me/", produces = "application/json")
public class UserController {

    @GetMapping
    public String me() {
        return "Helloword";
    }
}
