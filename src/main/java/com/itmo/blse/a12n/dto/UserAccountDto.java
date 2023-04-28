package com.itmo.blse.a12n.dto;

import com.itmo.blse.tournaments.model.Roles;
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
