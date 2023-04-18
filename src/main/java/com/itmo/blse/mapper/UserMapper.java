package com.itmo.blse.mapper;


import com.itmo.blse.dto.MatchDto;
import com.itmo.blse.dto.UserDto;
import com.itmo.blse.model.Match;
import com.itmo.blse.model.User;
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
