package com.itmo.blse.a12n.controller;

import com.itmo.blse.a12n.dto.UserRegistrationRequest;
import com.itmo.blse.a12n.service.UserRegistrationService;
import com.itmo.blse.app.error.ValidationError;
import com.itmo.blse.users.mapper.UserMapper;
import com.itmo.blse.users.model.User;
import com.itmo.blse.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth", produces = "application/json")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    UserRegistrationService userRegistrationService;

    @Autowired
    UserMapper userMapper;


    @PostMapping("/register/")
    public ResponseEntity<?> register(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        try {
            User user = userRegistrationService.register(userRegistrationRequest);
            return ResponseEntity.ok(userMapper.toUserDto(user));
        }
        catch (ValidationError err){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }


    }




}
