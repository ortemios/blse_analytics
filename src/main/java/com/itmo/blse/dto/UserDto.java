package com.itmo.blse.dto;

import com.itmo.blse.model.Team;
import com.itmo.blse.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    Long id;
    String username;

    public static UserDto fromUser(User user){
        return new UserDtoBuilder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }


}
