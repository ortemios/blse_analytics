package com.itmo.blse.dto;

import com.itmo.blse.model.Roles;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserAccountDto {

    String username;
    String password;
    List<Roles> roles;

}
