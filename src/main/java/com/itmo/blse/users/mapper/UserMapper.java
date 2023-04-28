package com.itmo.blse.users.mapper;


import com.itmo.blse.users.dto.UserDto;
import com.itmo.blse.users.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {


    public UserDto toUserDto(User user ){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();

    }

}
