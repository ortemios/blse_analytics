package com.itmo.blse.service;


import com.itmo.blse.dto.UserAccountDto;
import com.itmo.blse.errors.ValidationError;
import com.itmo.blse.model.Roles;
import com.itmo.blse.model.User;
import com.itmo.blse.repository.UserRepository;
import com.itmo.blse.security.UserAccount;
import com.itmo.blse.security.xml.UserXmlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserRegistrationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserXmlRepository userXmlRepository;

    @Resource(name = "passwordEncoder")
    PasswordEncoder passwordEncoder;


    public User register(UserAccountDto data) throws ValidationError {
        List<String> errors = new ArrayList<>();
        if (data.getUsername().length() < 3 || data.getUsername().length() > 32)
            errors.add("Invalid username");
        if (userRepository.getUserByUsername(data.getUsername()) != null)
            errors.add(String.format("User with username %s already exists", data.getUsername()));

        if (errors.size() > 0){
            throw new ValidationError(errors);
        }
        String encryptedPassword = passwordEncoder.encode(data.getPassword());
        userXmlRepository.addAccount(data.getUsername(), encryptedPassword);
        User user = User.builder()
                .username(data.getUsername())
                .roles(data.getRoles())
                .build();
        userRepository.save(user);
        return user;



    }

}
