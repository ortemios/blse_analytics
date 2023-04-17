package com.itmo.blse.service;


import com.itmo.blse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {

    @Autowired
    HttpServletRequest request;

    public User fromContext(){

        return (User)request.getAttribute("user");
    }

}
