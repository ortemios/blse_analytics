package com.itmo.blse.users.controller;

import com.itmo.blse.a12n.service.UserRegistrationService;
import com.itmo.blse.users.dto.UserDto;
import com.itmo.blse.users.mapper.UserMapper;
import com.itmo.blse.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
