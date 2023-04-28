package com.itmo.blse.a12n.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
    private String username;
    private String password;
}
