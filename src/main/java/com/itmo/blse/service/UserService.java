package com.itmo.blse.service;


import com.itmo.blse.repository.UserRepository;
import com.itmo.blse.security.xml.UserXmlRepository;
import com.itmo.blse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {

    @Autowired
    HttpServletRequest request;

    @Autowired
    UserRepository userRepository;

    public User fromContext(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            return userRepository.getUserByUsername(((UserDetails) authentication.getPrincipal()).getUsername());
        }

        return null;
    }

}
