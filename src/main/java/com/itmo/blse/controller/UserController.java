package com.itmo.blse.controller;

import com.itmo.blse.dto.UserAccountDto;
import com.itmo.blse.dto.UserDto;
import com.itmo.blse.errors.ValidationError;
import com.itmo.blse.mapper.UserMapper;
import com.itmo.blse.model.User;
import com.itmo.blse.repository.UserRepository;
import com.itmo.blse.security.UserAccount;
import com.itmo.blse.service.UserRegistrationService;
import com.itmo.blse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user", produces = "application/json")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRegistrationService userRegistrationService;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/me/")
    public UserDto me() {
        return userMapper.toUserDto(userService.fromContext());

    }

    @PostMapping("/register/")
    public ResponseEntity<?> register(@RequestBody UserAccountDto userAccountDto) {
        try {
            User user = userRegistrationService.register(userAccountDto);
            return ResponseEntity.ok(userMapper.toUserDto(user));
        }
        catch (ValidationError err){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }


    }




}
