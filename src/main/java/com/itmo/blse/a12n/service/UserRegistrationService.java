package com.itmo.blse.a12n.service;


import com.itmo.blse.a12n.dto.UserRegistrationRequest;
import com.itmo.blse.a12n.repository.UserAccountRepository;
import com.itmo.blse.app.error.ValidationError;
import com.itmo.blse.users.model.User;
import com.itmo.blse.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserRegistrationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserAccountRepository userAccountRepository;

    @Resource(name = "passwordEncoder")
    PasswordEncoder passwordEncoder;


    public User register(UserRegistrationRequest data) throws ValidationError {
        List<String> errors = new ArrayList<>();
        if (data.getUsername().length() < 3 || data.getUsername().length() > 32)
            errors.add("Invalid username");
        if (userRepository.getUserByUsername(data.getUsername()) != null)
            errors.add(String.format("User with username %s already exists", data.getUsername()));

        if (errors.size() > 0){
            throw new ValidationError(errors);
        }
        String encryptedPassword = passwordEncoder.encode(data.getPassword());
        userAccountRepository.addAccount(data.getUsername(), encryptedPassword);
        User user = User.builder()
                .username(data.getUsername())
                .roles(data.getRoles())
                .build();
        userRepository.save(user);
        return user;



    }

}
